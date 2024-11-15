package com.paulinaaniola.plantkeeperv2.data.repository.di

import com.paulinaaniola.plantkeeperv2.data.repository.PlantsRepository
import com.paulinaaniola.plantkeeperv2.data.repository.PlantsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPlantsRepository(
        recipeRepository: PlantsRepositoryImpl,
    ): PlantsRepository
}
