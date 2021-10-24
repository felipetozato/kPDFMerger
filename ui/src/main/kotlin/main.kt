import androidx.compose.ui.window.application

private val appStarter = Application()

fun main() = application {
    appStarter.bootstrapApp()
    appStarter.createMainWindow(this)
}