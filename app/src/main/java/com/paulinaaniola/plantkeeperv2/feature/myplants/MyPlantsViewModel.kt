package com.paulinaaniola.plantkeeperv2.feature.myplants

import androidx.lifecycle.ViewModel
import com.paulinaaniola.plantkeeperv2.model.Plant
import com.paulinaaniola.plantkeeperv2.model.PlantType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MyPlantsViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    val plants = mutableListOf(
        Plant("Monster", PlantType.PALM),
        Plant("palm",  PlantType.PALM),
        Plant("Random plant",  PlantType.PALM),
    )

    init {
        _uiState.value = UiState.Success(PlantsListState(plants.toList()))
    }

    fun addNewPlant() {
        plants.add(Plant("new",  PlantType.HERB),)
        _uiState.value = UiState.Success(PlantsListState(plants.toList()))
    }
}