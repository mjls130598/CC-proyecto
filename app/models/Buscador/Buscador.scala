package models.Buscador

import models.SharingNotes._
import java.util._
import Array._
import org.apache.lucene.index.IndexReader
import org.apache.lucene.search._
import org.apache.lucene.facet.taxonomy.directory.DirectoryTaxonomyReader
import org.apache.lucene.facet.taxonomy.TaxonomyReader
import org.apache.lucene.facet._
import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.core.KeywordAnalyzer
import org.apache.lucene.search.similarities.BM25Similarity
import org.apache.lucene.analysis.es.SpanishAnalyzer
import org.apache.lucene.analysis.core.WhitespaceAnalyzer
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.facet.FacetField
import org.apache.lucene.document._
import java.nio.file.Paths
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.index.DirectoryReader

import org.slf4j.LoggerFactory

class Buscador{

    // CONFIGURACIÓN BUSCADOR

    // Se indican el nombre de los directorios donde se almacenan el índice y las facetas (filtros)

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
    analyzerPerField.put("id", new KeywordAnalyzer())

    // Se crea el analizador para todos los datos que se indexen

    val analyzer = new PerFieldAnalyzerWrapper (new WhitespaceAnalyzer(), analyzerPerField)

    // Se indica qué medida de similaridad se va a aplicar, en este caso BM25.

    val similarity = new BM25Similarity()

    // Se abren los directorios que almacenan el índice y las facetas (filtros)

    val indexDir = FSDirectory.open (Paths.get(indexPath));
    val taxoDir = FSDirectory.open (Paths.get(facetPath));

    // Variable para poder escribir los mensajes de log

    private val logger = LoggerFactory.getLogger(getClass.getSimpleName)

    // Método encargado de realizar las búsquedas

    def buscar(consulta: Option[String], universidad: Option[String], carrera: Option[String],
        asignatura: Option[String], curso: Option[String]) : scala.collection.immutable.List[Apunte] = {

        logger.info(s"Búsqueda de: $consulta, con filtros {universidad: $universidad, " +
        "carrera: $carrera, curso: $curso, asignatura: $asignatura")

        // Abrir los directorios "indice" y "facetas"

        val reader = DirectoryReader.open(indexDir)
        val searcher: IndexSearcher = new IndexSearcher(reader)
        val taxoReader: TaxonomyReader = new DirectoryTaxonomyReader(taxoDir)

        searcher.setSimilarity(similarity)

        // Función que se encarga de realizar las búsquedas

        def realizarConsulta(query: Query) : Array[ScoreDoc] = {

            val fc = new FacetsCollector();
            val fconf = new FacetsConfig()
            val ddq = new DrillDownQuery(fconf, query)

            var resultados = FacetsCollector.search(searcher, query, 20, fc)
            var hitsConsulta = resultados.scoreDocs

            // Se filtra según los tipos de filtros dados

            hitsConsulta = universidad match {
                case Some(uni) => filtrar("Universidad", uni)
                case None => hitsConsulta
            }

            hitsConsulta = carrera match {
                case Some(car) => filtrar("Carrera", car)
                case None => hitsConsulta
            }

            hitsConsulta = curso match {
                case Some(cur) => filtrar("Curso", cur)
                case None => hitsConsulta
            }

            hitsConsulta = asignatura match {
                case Some(asig) => filtrar("Asignatura", asig)
                case None => hitsConsulta
            }

            // Función que se encarga de realizar los distintos filtrados sobre una consulta

            def filtrar(llave: String, valor: String): Array[ScoreDoc] = {

                ddq.add(llave, valor)

                val fc = new FacetsCollector()
                val results = FacetsCollector.search(searcher, ddq, 20, fc)
                
                return results.scoreDocs
            }

            return hitsConsulta
        }

        val parserTitulo = new QueryParser ("Título", analyzerPerField.get("Título"))
        val parserContenido = new QueryParser ("Contenido", analyzerPerField.get("Contenido"))

        // Se obtienen los resultados dependiendo de la consulta realizada

        lazy val hits = consulta match { 
            case Some(con) => concat(realizarConsulta(parserTitulo.parse(con)), 
                realizarConsulta(parserContenido.parse(con))).sortBy(_.score)

            case None => realizarConsulta(new MatchAllDocsQuery())
        }

        return hits.map(hit => {
            val doc = searcher.doc(hit.doc)
            val id = doc.get("id")
            SharingNotes.getApuntes(id)
        }).toList
    }
}