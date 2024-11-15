package com.paulinaaniola.plantkeeperv2.feature.addplant

sealed class UiState {
    object Loading : UiState()
    data class AddEdit(
        val state: AddPlantState
    ) : UiState()

    object OnSaveSuccess : UiState()
}
