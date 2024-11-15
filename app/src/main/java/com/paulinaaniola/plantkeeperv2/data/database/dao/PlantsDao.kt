package com.paulinaaniola.plantkeeperv2.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paulinaaniola.plantkeeperv2.data.database.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface PlantsDao : PlantsLocal {

    @Query("SELECT * FROM plantentity")
    override fun getAllPlants(): Flow<List<PlantEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun setPlant(plant: PlantEntity)
}
