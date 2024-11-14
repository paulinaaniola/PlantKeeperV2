package com.paulinaaniola.plantkeeperv2.feature.addplant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.paulinaaniola.plantkeeperv2.R
import com.paulinaaniola.plantkeeperv2.ui.components.FormField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewPlantScreen(
    navController: NavController,
    viewModel: AddNewPlantViewModel = hiltViewModel(),
) {
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
        content = { paddingValues ->
            MyPlantsScreenContent(paddingValues, viewModel)
        }
    )
}

@Composable
fun MyPlantsScreenContent(
    paddingValues: PaddingValues,
    viewModel: AddNewPlantViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    Column(
        modifier = modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxWidth()
    ) {
        if (uiState is UiState.AddEdit) {
            AddPlantForm(uiState.state, viewModel::onNameChange)
        } else {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(80.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlantForm(
    uiState: AddPlantState,
    onNameChange: (String) -> Unit
) {
    LazyColumn {
        item {
            FormField(uiState.name, R.string.name, { onNameChange.invoke(it) })
        }
    }
}