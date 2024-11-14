package com.paulinaaniola.plantkeeperv2.feature.myplants

sealed class UiState {
    object Loading : UiState()
    data class Success(
        val state: PlantsListState
    ) : UiState()
}
