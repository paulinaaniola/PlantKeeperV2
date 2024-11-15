package com.paulinaaniola.plantkeeperv2.data.database.dao

import com.paulinaaniola.plantkeeperv2.data.database.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

interface PlantsLocal {
    fun getAllPlants(): Flow<List<PlantEntity>>
    suspend fun setPlant(plant: PlantEntity)
}