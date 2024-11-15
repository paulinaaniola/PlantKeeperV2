package com.paulinaaniola.plantkeeperv2.data.repository

import com.paulinaaniola.plantkeeperv2.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    fun getPlants(): Flow<List<Plant>>
    suspend fun setPlant(plant: Plant)
}
