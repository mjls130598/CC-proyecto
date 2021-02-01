package Buscador

import java.io._
import org.apache.tika.parser.pdf.PDFParser
import org.apache.tika.metadata._
import org.apache.tika.parser._
import org.xml.sax._
import org.apache.tika.sax.BodyContentHandler

object ExtraeTexto{

  def textoPDF (archivo: String) : String = {

    val pdf: PDFParser = new PDFParser();
    val stream: InputStream = new FileInputStream(archivo)
    val handler: ContentHandler = new BodyContentHandler()
    val metadata: Metadata = new Metadata()
    val context: ParseContext = new ParseContext()
    metadata.set("org.apache.tika.parser.pdf.sortbyposition", "true")
    metadata.set("org.apache.tika.parser.pdf.enableAutoSpace", "true")
    pdf.parse(stream, handler, metadata, context)

    stream.close()

    return handler.toString()
  }
}
