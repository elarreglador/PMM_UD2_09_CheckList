package com.elarreglador.pmm_ud2_09_checklist.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elarreglador.ud2_09_q.reusable.TextCheck

@Composable
fun CheckListViewer(navController: NavController, listado: SnapshotStateList<TextCheck>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item {
            Row(
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(60.dp)
                    .padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 10.dp
                    )
                    .background(Color.Gray)
            ) {
                Button(
                    onClick = { navController.navigate("checkListEditor") }
                ) {
                    Text("Editar lista")
                }
            }
        } // Row Botonera

        items(listado.size) { index ->
            val item = listado[index]
            Row (
                verticalAlignment = CenterVertically,
            ){
                Checkbox(
                    checked = item.isChecked,
                    onCheckedChange = { /* No hacer nada */ }
                )

                Text(item.text)
            }
        } // items Checkbox

    } // LazyColumn

}

@Preview(showSystemUi = true)
@Composable
fun CheckListViewerPreview(){
    val navController = rememberNavController()
    val listado = remember { mutableStateListOf<TextCheck>() }
    CheckListViewer(navController, listado)
}