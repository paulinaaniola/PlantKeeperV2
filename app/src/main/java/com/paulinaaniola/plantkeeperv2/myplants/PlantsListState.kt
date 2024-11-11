package com.paulinaaniola.plantkeeperv2.myplants

data class PlantsListState(
    val allPlants: List<PlantDTO>,
    val query: String = "",
)

data class PlantDTO(val plantName: String, val needsWatering: Boolean)
