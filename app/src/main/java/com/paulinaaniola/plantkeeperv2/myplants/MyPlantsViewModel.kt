package com.paulinaaniola.plantkeeperv2.myplants

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPlantsViewModel @Inject constructor() : ViewModel() {

    val plants = listOf(
        PlantDTO("Monster", true),
        PlantDTO("palm", false),
        PlantDTO("Random plant", false)
    )
}
