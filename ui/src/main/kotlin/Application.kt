import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import mainView.MainScreen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class Application : KoinComponent {

    private val mainScreen: MainScreen by inject()

    fun startApp() {
        createThemedWindow()
        setupKoin()
    }

    private fun createThemedWindow() = Window {
        MaterialTheme {
            mainScreen.createScreen()
        }
    }

    private fun setupKoin() {
        startKoin {
            modules(listOf(coreModule, uiModule))
        }
    }
}