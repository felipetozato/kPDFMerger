package actionView

import kotlinx.coroutines.flow.Flow

class ActionInteractor(private val presenter: ActionPresenter) {

}

interface ActionPresenter {

    fun onAddFilesClick(): Flow<Unit>
}