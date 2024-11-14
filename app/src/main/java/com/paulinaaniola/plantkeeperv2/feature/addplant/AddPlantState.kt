package com.paulinaaniola.plantkeeperv2.feature.addplant

import com.paulinaaniola.plantkeeperv2.model.PlantType

data class AddPlantState(
    val name: String = "",
    val type: PlantType = PlantType.HERB
)