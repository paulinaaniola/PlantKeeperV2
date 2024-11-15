package com.paulinaaniola.plantkeeperv2.data.database

import android.content.Context
import androidx.room.Room
import com.paulinaaniola.plantkeeperv2.data.database.dao.PlantsLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesPlantsDatabase(
        @ApplicationContext context: Context,
    ): PlantsDatabase = Room.databaseBuilder(
        context,
        PlantsDatabase::class.java,
        "plants-database",
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providePlantsLocal(
        plantsDatabase: PlantsDatabase
    ): PlantsLocal {
        return plantsDatabase.plantsDao()
    }
}
