package helper

import org.apache.commons.io.FileUtils
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import java.io.File

object FileFactoryHelper {

    fun createTextFile(fileName: String) {
        val file = File(fileName)
        file.writeText(randomTextGenerator())
    }

    fun createDirectory(directoryName: String) {
        val file = File(directoryName)
        file.mkdir()
    }

    fun createPDFFile(fileName: String) {
        val pdDoc = PDDocument()
        val page = PDPage()
        val font = PDType1Font.COURIER
        val stream =  PDPageContentStream(pdDoc, page, PDPageContentStream.AppendMode.OVERWRITE, true, true)
        stream.beginText()
        stream.setFont(font, 14f)
        stream.showText(randomTextGenerator())
        stream.endText()
        stream.close()
        pdDoc.addPage(page)
        val file = File(fileName)
        file.setReadable(true)
        pdDoc.save(file)
        pdDoc.close()
    }

    private fun  randomTextGenerator() : String {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        return (1..100)
            .map { _ -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }

    fun deleteFolder(folderName: String) {
        val file = File(folderName)
        FileUtils.deleteDirectory(file)
    }

    fun deleteFile(fileName: String) {
        val file = File(fileName)
        file.delete()
    }
}