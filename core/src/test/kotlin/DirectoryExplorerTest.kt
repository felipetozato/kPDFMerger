import helper.FileFactoryHelper
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.nio.file.NotDirectoryException
import kotlin.test.assertSame
import kotlin.test.assertTrue

class DirectoryExplorerTest {

    private val directoryExplorer = DirectoryExplorer()

    companion object {
        private const val FILE_NAME1 = "textfile.txt"
        private const val EMPTY_DICT = "emptyDict"
        private const val DIC_NAME = "myDict"
        private const val PDF_NAME = "pdffile.pdf"
        private const val PDF_NAME2 = "pdffile2.pdf"


        @BeforeAll
        @JvmStatic
        fun envSetup() {
            FileFactoryHelper.createDirectory(EMPTY_DICT)
            FileFactoryHelper.createDirectory(DIC_NAME)
            FileFactoryHelper.createTextFile(FILE_NAME1)
            FileFactoryHelper.createTextFile("$DIC_NAME/$FILE_NAME1")
            FileFactoryHelper.createPDFFile("$DIC_NAME/$PDF_NAME")
            FileFactoryHelper.createPDFFile("$DIC_NAME/$PDF_NAME2")
        }

        @AfterAll
        @JvmStatic
        fun envCleanup() {
            FileFactoryHelper.deleteFolder(EMPTY_DICT)
            FileFactoryHelper.deleteFolder(DIC_NAME)
        }
    }

    @Test
    fun `getAllPdfFileNames of not directory and return exception`() {
        assertThrows<NotDirectoryException> {
            directoryExplorer.getAllPdfFileNames(FILE_NAME1)
        }
    }

    @Test
    fun `getAllPdfFileNames of empty folder and return empty list`()  {
        val listOfFiles = directoryExplorer.getAllPdfFileNames(EMPTY_DICT)

        assert(listOfFiles.isEmpty())
    }

    @Test
    fun `getAllPdfFileNames with txt and pdf return only pdf`() {
        val listOfFiles = directoryExplorer.getAllPdfFileNames(DIC_NAME)

        assertTrue(listOfFiles.isNotEmpty())
        assertSame(2, listOfFiles.size)
        assertTrue {
            listOfFiles.none { it.contains(FILE_NAME1) }
        }
    }
}