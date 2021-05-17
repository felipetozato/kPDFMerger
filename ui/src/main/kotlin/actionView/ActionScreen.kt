package actionView

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import base.BaseScreen

class ActionScreen: BaseScreen() {

    @Composable
    override fun createScreen() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(content = { Text("Adicionar Arquivo") },shape = MaterialTheme.shapes.medium, onClick = {})
            Button(content = { Text("Ordenar Arquivos")}, shape = MaterialTheme.shapes.medium, onClick = {})
        }
    }
}