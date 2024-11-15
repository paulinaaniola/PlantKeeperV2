package com.paulinaaniola.plantkeeperv2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paulinaaniola.plantkeeperv2.data.database.dao.PlantsDao
import com.paulinaaniola.plantkeeperv2.data.database.entity.PlantEntity

@Database(
    entities = [
        PlantEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class PlantsDatabase : RoomDatabase() {
    internal abstract fun plantsDao(): PlantsDao
}