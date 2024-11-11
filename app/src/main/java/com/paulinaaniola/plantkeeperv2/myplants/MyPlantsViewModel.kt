package com.paulinaaniola.plantkeeperv2.myplants

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MyPlantsViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    val plants = mutableListOf(
        PlantDTO("Monster", true, 1),
        PlantDTO("palm", false, 2),
        PlantDTO("Random plant", false, 5)
    )

    init {
        _uiState.value = UiState.Success(PlantsListState(plants.toList()))
    }

    fun addNewPlant() {
        plants.add(PlantDTO("new", true, 8))
        _uiState.value = UiState.Success(PlantsListState(plants.toList()))
    }
}
