package com.paulinaaniola.plantkeeperv2.myplants

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MyPlantsScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPlantsViewModel = hiltViewModel()
) {
    MyPlantsList(
        plants = viewModel.plants,
        modifier = modifier
    )
}

@Composable
internal fun MyPlantsList(
    plants: List<PlantDTO>,
    modifier: Modifier = Modifier
) {
   LazyColumn {
        items(plants) {
            Text("Saved plant: ${it.plantName}")
        }
    }
}