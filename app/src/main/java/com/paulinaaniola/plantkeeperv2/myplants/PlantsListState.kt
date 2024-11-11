package com.paulinaaniola.plantkeeperv2.myplants

data class PlantsListState(
    val plants: List<PlantDTO>,
    val query: String = "",
)

data class PlantDTO(val plantName: String, val needsWatering: Boolean)
