package com.paulinaaniola.plantkeeperv2.feature.myplants

import com.paulinaaniola.plantkeeperv2.model.Plant

data class PlantsListState(
    val plants: List<Plant>,
    val query: String = "",
)
