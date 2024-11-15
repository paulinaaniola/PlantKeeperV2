package com.paulinaaniola.plantkeeperv2.feature.addplant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import com.paulinaaniola.plantkeeperv2.R
import com.paulinaaniola.plantkeeperv2.ui.components.FormField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewPlantScreen(
    onAddSuccess: () -> Unit,
    viewModel: AddNewPlantViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.add_new_plant),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(viewModel::onSaveClick ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save new plant button",
                )
            }
        },
        content = { paddingValues ->
            MyPlantsScreenContent(paddingValues, viewModel, onAddSuccess )
        }
    )
}

@Composable
fun MyPlantsScreenContent(
    paddingValues: PaddingValues,
    viewModel: AddNewPlantViewModel,
    onAddSuccess: () -> Unit,
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
        } else if(uiState is UiState.OnSaveSuccess) {
            onAddSuccess.invoke()
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