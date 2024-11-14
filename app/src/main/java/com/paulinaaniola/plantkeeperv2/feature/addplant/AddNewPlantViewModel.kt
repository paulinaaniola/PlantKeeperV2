package com.paulinaaniola.plantkeeperv2.feature.addplant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulinaaniola.plantkeeperv2.di.DispatcherDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewPlantViewModel @Inject constructor(
    @DispatcherDefault private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.AddEdit(AddPlantState()))
    val uiState: StateFlow<UiState> = _uiState

    fun onNameChange(name: String) {
        viewModelScope.launch(dispatcher) {
            if (_uiState.value is UiState.AddEdit) {
                val newState = (_uiState.value as UiState.AddEdit).state.copy(name = name)
                _uiState.emit(UiState.AddEdit(newState))
            }
        }
    }
}