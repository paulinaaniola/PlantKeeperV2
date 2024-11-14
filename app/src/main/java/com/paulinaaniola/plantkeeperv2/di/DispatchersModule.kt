package com.paulinaaniola.plantkeeperv2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @DispatcherIo
    @Provides
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DispatcherDefault
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DispatcherDefault

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DispatcherIo
