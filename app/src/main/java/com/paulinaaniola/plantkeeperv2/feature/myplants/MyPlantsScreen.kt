package com.paulinaaniola.plantkeeperv2.feature.myplants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.paulinaaniola.plantkeeperv2.R
import com.paulinaaniola.plantkeeperv2.model.Plant
import com.paulinaaniola.plantkeeperv2.navigation.NavigationItem
import com.paulinaaniola.plantkeeperv2.ui.components.PlantItem
import com.paulinaaniola.plantkeeperv2.ui.components.TopBar

@Composable
fun MyPlantsScreen(
    navController: NavController,
    viewModel: MyPlantsViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    Scaffold(
        topBar = {
            TopBar(stringResource(R.string.my_plants))
        },
        floatingActionButton = {
            FloatingActionButton({
                navController.navigate(NavigationItem.AddPlant.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add new plan button",
                )
            }
        },
        content = { paddingValues ->
            MyPlantsScreenContent(paddingValues, uiState)
        }
    )
}

@Composable
fun MyPlantsScreenContent(
    paddingValues: PaddingValues,
    uiState: UiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxWidth()
    ) {
        if (uiState is UiState.Success) {
            MyPlantsList(
                plants = uiState.state.plants,
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(80.dp)
            )
        }
    }
}

@Composable
internal fun MyPlantsList(
    plants: List<Plant>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(plants) { plant ->
            PlantItem(plant)
        }
    }
}
