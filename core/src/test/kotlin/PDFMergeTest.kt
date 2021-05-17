import helper.FileFactoryHelper
import org.apache.pdfbox.pdmodel.PDDocument
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class PDFMergeTest {


    companion object {

        private const val FILE1 = "FILE1.pdf"
        private const val FILE2 = "FILE2.pdf"
        private const val OUTPUT_FILE = "OUTPUT_FILE"

        @BeforeAll
        @JvmStatic
        fun envSetup() {
            FileFactoryHelper.createPDFFile(FILE1)
            FileFactoryHelper.createPDFFile(FILE2)
        }

        @AfterAll
        @JvmStatic
        fun envCleanup() {
            FileFactoryHelper.deleteFile(FILE1)
            FileFactoryHelper.deleteFile(FILE2)
            FileFactoryHelper.deleteFile("$OUTPUT_FILE.pdf")
        }
    }

    @Test
    fun `test merge return created file`() {
        val files = arrayOf(FILE1, FILE2)
        val merger = PDFMerger(files)
        val outputFilePath = merger.merge(OUTPUT_FILE)

        assertNotNull(outputFilePath)
        val outputFile = File(outputFilePath)
        assertTrue(outputFile.isFile)
        assertEquals("pdf", outputFile.extension)

        val pdfDoc = PDDocument.load(outputFile)
        assertEquals(2, pdfDoc.pages.count)
        pdfDoc.close()
    }
}