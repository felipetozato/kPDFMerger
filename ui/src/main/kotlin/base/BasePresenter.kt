package base

interface BasePresenter<T: BaseViewModel> {
    val viewModel: T
}