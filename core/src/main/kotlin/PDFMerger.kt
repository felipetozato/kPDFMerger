import exceptions.PDFOpenException
import org.apache.pdfbox.pdmodel.PDDocument
import java.io.File
import java.util.*

class PDFMerger(override val files: Array<String>) : FileMerger {

    private var savedDocumentName: String? = null

    val mergedDocumentName get() = savedDocumentName

    /**
     * Merge files passed as parameter.
     *
     * @return merged file path.
     */
    override fun merge(outputFileName: String): String {
        val mergeDoc = PDDocument()

        files.forEach {fileName ->
            val file = File(fileName)
            if (!(file.isFile && file.canRead() && file.name.endsWith("pdf"))) {
                throw PDFOpenException("Unable to open or read $fileName. Check file permission.")
            }

            val pdfDoc = PDDocument.load(file)
            pdfDoc.pages.forEach(mergeDoc::importPage)
        }

        val mergedFile = File("$outputFileName.pdf")
        mergeDoc.save(mergedFile)
        mergeDoc.close()
        savedDocumentName = mergedFile.absolutePath

        return mergedFile.absolutePath
    }
}