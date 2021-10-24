package fileList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import base.BaseScreen

class FileListScreen: BaseScreen() {

    @Composable
    override fun createScreen() {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Lista de arquivos a juntar")
            LazyColumn(modifier = Modifier.zIndex(1f).padding(top = 16.dp)) {
                items(listOf(1,2,3,4,5)) { index ->
                    ListRow("Arquivo $index", Color.White)
                }
            }
        }
    }

    @Composable
    private fun ListRow(title: String, bgColor: Color) {
        Box(Modifier.padding(bottom = 8.dp)
            .fillMaxSize()
            .zIndex(2f)
            .background(bgColor, RoundedCornerShape(40))) {
            Text(title, modifier = Modifier.padding(4.dp).padding(start = 8.dp))
        }
    }
}