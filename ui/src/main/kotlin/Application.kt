import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import mainView.MainScreen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class Application : KoinComponent {

    private val mainScreen: MainScreen by inject()

    fun bootstrapApp() {
        setupKoin()
    }

    @Preview
    @Composable
    fun createMainWindow(applicationScope: ApplicationScope) {
        Window(onCloseRequest = applicationScope::exitApplication) {
            MaterialTheme {
                mainScreen.createScreen()
            }
        }
    }

    private fun setupKoin() {
        startKoin {
            modules(listOf(coreModule, uiModule))
        }
    }
}