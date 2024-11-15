package com.paulinaaniola.plantkeeperv2.feature.myplants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulinaaniola.plantkeeperv2.data.repository.PlantsRepository
import com.paulinaaniola.plantkeeperv2.di.DispatcherIo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPlantsViewModel @Inject constructor(
    @DispatcherIo val dispatcher: CoroutineDispatcher,
    val plantsRepository: PlantsRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        viewModelScope.launch(dispatcher) {
            plantsRepository.getPlants().map { plants -> UiState.Success(PlantsListState(plants)) }
                .collect {
                    _uiState.value = it
                }
        }
    }
}
