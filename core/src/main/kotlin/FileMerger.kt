interface FileMerger {

    val files: Array<String>

    fun merge(outputFileName: String): String
}