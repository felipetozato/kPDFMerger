package mainView

import actionView.ActionScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import base.BasePresenter
import base.BaseScreen
import base.BaseViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreen : BaseScreen(), MainPresenter, KoinComponent {

    override val viewModel: MainViewModel = MainViewModel()

    private val actionScreen: ActionScreen by inject()
    @Composable
    override fun createScreen() {
        Row {
            Box (modifier = Modifier.weight(1f).fillMaxSize().background(Color.Red)) { }
            Box (modifier = Modifier.weight(1f).fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                actionScreen.createScreen()
            }
        }
    }
}

interface MainPresenter : BasePresenter<MainViewModel>

class MainViewModel : BaseViewModel {
    internal val text: MutableState<String> = mutableStateOf("Hello, Desktop!")
}

