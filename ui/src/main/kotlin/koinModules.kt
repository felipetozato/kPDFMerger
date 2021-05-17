import actionView.ActionScreen
import mainView.MainInteractor
import mainView.MainPresenter
import mainView.MainScreen
import org.koin.dsl.module

val coreModule = module {
    single { DirectoryExplorer() }
}

val uiModule = module {
    // Main Screen
    factory { MainScreen() }
    single  { MainInteractor(get()) }
    fun mainPresente(screen: MainScreen): MainPresenter = screen
    factory { mainPresente(get()) }

    // Actions Screen
    factory { ActionScreen() }
}