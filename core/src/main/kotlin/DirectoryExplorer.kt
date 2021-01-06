import java.io.File
import java.nio.file.NotDirectoryException

class DirectoryExplorer {

    fun getAllPdfFileNames(directory: String): Array<String> {
        val dir = File(directory)
        if (!dir.isDirectory) throw NotDirectoryException(directory)

        return dir.list { _, name ->  name.endsWith(".pdf") }!!
    }
}