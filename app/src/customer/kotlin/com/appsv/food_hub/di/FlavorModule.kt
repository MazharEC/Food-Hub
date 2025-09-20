package com.appsv.food_hub.di

import com.appsv.food_hub.data.SocketService
import com.appsv.food_hub.data.repository.CustomerLocationUpdateSocketRepository
import com.appsv.food_hub.ui.features.orders.LocationUpdateBaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FlavorModule {
    @Provides
    fun provideLocationUpdateSocketRepository(
        socketService: SocketService,
    ): LocationUpdateBaseRepository {
        return CustomerLocationUpdateSocketRepository(socketService)
    }
}
