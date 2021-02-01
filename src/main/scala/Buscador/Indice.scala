package Buscador

import SharingNotes._
import java.util._
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.facet.taxonomy.directory.DirectoryTaxonomyWriter
import org.apache.lucene.facet.FacetsConfig
import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.core.KeywordAnalyzer
import org.apache.lucene.search.similarities.BM25Similarity
import org.apache.lucene.analysis.es.SpanishAnalyzer
import org.apache.lucene.analysis.core.WhitespaceAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field.Store
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.facet.FacetField
import org.apache.lucene.document.StoredField
import org.apache.lucene.document.TextField
import org.apache.lucene.document.StringField
import org.apache.lucene.index.IndexWriterConfig
import java.nio.file.Paths
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper

import org.slf4j.LoggerFactory

class Indice {

  // CONFIGURACIÓN DEL ÍNDICE

  // Se indican el nombre de los directorios donde se almacenarán el índice y las facetas (filtros)

  val indexPath = "./indice"
  val facetPath = "./facetas"

  // Se indican qué tipo de analizadores se van a encargar de cada dato del apunte

  val analyzerPerField : Map[String, Analyzer] = new HashMap[String, Analyzer]()
  analyzerPerField.put("Título", new SpanishAnalyzer())
  analyzerPerField.put("Contenido", new SpanishAnalyzer())
  analyzerPerField.put("Universidad", new KeywordAnalyzer())
  analyzerPerField.put("Carrera", new KeywordAnalyzer())
  analyzerPerField.put("Curso", new KeywordAnalyzer())
  analyzerPerField.put("Asignatura", new KeywordAnalyzer())

  // Se crea el analizador para todos los datos que se indexen

  val analyzer = new PerFieldAnalyzerWrapper (new WhitespaceAnalyzer(), analyzerPerField)

  // Se indica qué medida de similaridad se va a aplicar, en este caso BM25.

  val similarity = new BM25Similarity()

  // Se configura el índice con los analizadores y la medida anterior
  // Además, se le indica que se abra para crear

  val iwc = new IndexWriterConfig(analyzer)
  iwc.setSimilarity(similarity)
  iwc.setOpenMode (IndexWriterConfig.OpenMode.CREATE)

  // Se abren los directorios que almacenan el índice y las facetas (filtros)

  val indexDir = FSDirectory.open (Paths.get(indexPath));
  val taxoDir = FSDirectory.open (Paths.get(facetPath));

  // Con los directorios y la configuración anteriores, ya se puede comenzar a indexar

  val writer = new IndexWriter (indexDir, iwc)
  val taxoWriter = new DirectoryTaxonomyWriter (taxoDir)
  var fconfig : FacetsConfig = new FacetsConfig()

  // Variable para poder escribir los mensajes de log

  private val logger = LoggerFactory.getLogger(getClass.getSimpleName)

  // Indexación de documentos

  def indexarDocumentos : Unit = {

    // Para cada uno de los apuntes guardados

    SharingNotes.getApuntes.foreach{

      case (key, value) => {

        val doc = new Document();

        // Se indexan los distintos datos de un apunte

        doc.add(new TextField("Titulo", value.nombre, Store.YES))
        doc.add(new TextField("Contenido", ExtraeTexto.textoPDF(value.ubicacion), Store.YES))
        doc.add(new StringField("Universidad", value.asignatura.universidad, Store.YES))
        doc.add(new StringField("Carrera", value.asignatura.carrera, Store.YES))
        doc.add(new StringField("Curso", value.asignatura.curso, Store.YES))
        doc.add(new StringField("Asignatura", value.asignatura.nombre, Store.YES))
    		doc.add (new StoredField ("id", key))

        // Se crean las distintas facetas (filtros)

        doc.add(new FacetField ("Universidad", value.asignatura.universidad))
        doc.add(new FacetField("Carrera", value.asignatura.carrera))
        doc.add(new FacetField("Curso", value.asignatura.curso))
        doc.add(new FacetField("Asignatura", value.asignatura.nombre))

        // Se añade al directorio donde se guardan las facetas y el índice

    		writer.addDocument(fconfig.build(taxoWriter, doc))
      }
    }

    logger.info("Creado índice y facetas")

    // Se guardan los cambios y se cierran los encargados de la indexación

    writer.commit();
    writer.close();
    taxoWriter.close();
  }
}
