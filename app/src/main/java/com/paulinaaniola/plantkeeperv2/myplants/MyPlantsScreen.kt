package com.paulinaaniola.plantkeeperv2.myplants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.paulinaaniola.plantkeeperv2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPlantsScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPlantsViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(viewModel::addNewPlant) {
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
    plants: List<PlantDTO>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(plants) {
            Text("Saved plant: ${it.plantName}")
        }
    }
}