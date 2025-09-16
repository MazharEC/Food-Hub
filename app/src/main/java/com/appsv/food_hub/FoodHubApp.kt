package com.appsv.food_hub

import android.app.Application
import com.appsv.food_hub.notification.FoodHubNotificationManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FoodHubApp : Application()  {

    @Inject
    lateinit var foodHubNotificationManager: FoodHubNotificationManager
    override fun onCreate() {
        super.onCreate()
        foodHubNotificationManager.createChannels()
        foodHubNotificationManager.getAndStoreToken()
    }
}