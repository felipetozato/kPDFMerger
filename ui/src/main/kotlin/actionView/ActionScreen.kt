package actionView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import base.BaseScreen
import kotlinx.coroutines.flow.*

class ActionScreen: BaseScreen(), ActionPresenter {

    private val addFileFlow = MutableSharedFlow<Unit>()

    @Composable
    override fun createScreen() {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)) {
            createButtons("Adicinar Arquivos", addFileFlow)
        }
    }

    @Composable
    private fun createButtons(text: String, onClick: MutableSharedFlow<Unit>) {
        Button(content = { Text(text) },shape = MaterialTheme.shapes.medium, onClick = { onClick.tryEmit(Unit) },
        modifier = Modifier.padding(PaddingValues(0.dp, 0.dp, 0.dp, 16.dp)))
    }

    override fun onAddFilesClick(): Flow<Unit> = addFileFlow
}