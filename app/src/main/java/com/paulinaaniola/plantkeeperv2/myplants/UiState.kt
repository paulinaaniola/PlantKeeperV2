package com.paulinaaniola.plantkeeperv2.myplants

sealed class UiState {
    object Loading : UiState()
    data class Success(
        val state: PlantsListState
    ) : UiState()
}
