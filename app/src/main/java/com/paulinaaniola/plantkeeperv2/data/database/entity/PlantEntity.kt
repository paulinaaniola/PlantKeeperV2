package com.paulinaaniola.plantkeeperv2.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.paulinaaniola.plantkeeperv2.model.Plant
import com.paulinaaniola.plantkeeperv2.model.PlantType

@Entity
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String
)

fun Plant.toEntity(): PlantEntity {
    return PlantEntity(id = id, name = plantName)
}

fun PlantEntity.toPlant(): Plant {
    return Plant(id = id, plantName = name, plantType = PlantType.PALM)
}
