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

    init {
        val plants = listOf(
            PlantDTO("Monster", true),
            PlantDTO("palm", false),
            PlantDTO("Random plant", false)
        )
        _uiState.value = UiState.Success(PlantsListState(plants))
    }
}
