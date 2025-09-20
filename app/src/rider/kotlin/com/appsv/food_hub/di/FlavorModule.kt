package com.appsv.food_hub.di

import com.appsv.food_hub.data.SocketService
import com.appsv.food_hub.location.LocationManager
import com.appsv.food_hub.ui.features.orders.order_map.LocationUpdateBaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FlavorModule{
    @Provides
    fun provideLocationUpdateSocketRepository(
        socketService: SocketService,
        locationManager: LocationManager
    ): LocationUpdateBaseRepository {
        return LocationUpdateSocketRepository(socketService, locationManager)
    }
}