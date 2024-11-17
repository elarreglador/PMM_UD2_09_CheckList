package com.elarreglador.pmm_ud2_09_checklist.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elarreglador.pmm_ud2_09_checklist.screens.CheckListEditor
import com.elarreglador.pmm_ud2_09_checklist.screens.CheckListViewer
import com.elarreglador.ud2_09_q.reusable.TextCheck

@Composable
fun Navigator() {

    // Estado compartido entre pantallas
    val listado = remember { mutableStateListOf<TextCheck>() }

    // Navegacion
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "CheckListEditor") {
        composable("CheckListEditor") {
            CheckListEditor(navController, listado)
        }
        composable("CheckListViewer") {
            CheckListViewer(navController, listado)
        }
    }

}