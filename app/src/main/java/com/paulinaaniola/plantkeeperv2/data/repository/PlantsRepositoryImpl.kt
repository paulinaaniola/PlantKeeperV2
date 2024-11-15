package com.paulinaaniola.plantkeeperv2.data.repository

import com.paulinaaniola.plantkeeperv2.data.database.dao.PlantsLocal
import com.paulinaaniola.plantkeeperv2.data.database.entity.toEntity
import com.paulinaaniola.plantkeeperv2.data.database.entity.toPlant
import com.paulinaaniola.plantkeeperv2.model.Plant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlantsRepositoryImpl  @Inject constructor(
    val plantsLocal: PlantsLocal
) : PlantsRepository {

    override fun getPlants(): Flow<List<Plant>> {
        return plantsLocal.getAllPlants().map { it.map { plantEntity -> plantEntity.toPlant() } }
    }

    override suspend fun setPlant(plant: Plant) {
        plantsLocal.setPlant(plant.toEntity())
    }
}
