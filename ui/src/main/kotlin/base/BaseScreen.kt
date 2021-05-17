package base

import androidx.compose.runtime.Composable
import kotlinx.coroutines.MainScope

abstract class BaseScreen {

    protected val scope = MainScope()

    @Composable
    abstract fun createScreen()
}