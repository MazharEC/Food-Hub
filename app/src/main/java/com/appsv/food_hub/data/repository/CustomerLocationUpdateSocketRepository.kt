package com.appsv.food_hub.data.repository

import com.appsv.food_hub.data.SocketService
import com.appsv.food_hub.ui.features.orders.LocationUpdateBaseRepository
import javax.inject.Inject

class CustomerLocationUpdateSocketRepository @Inject constructor(socketService: SocketService) :
    LocationUpdateBaseRepository(socketService) {

    override fun connect(orderID: String, riderID: String) {
        try {
            socketService.connect(
                orderID, riderID, null, null
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    override fun disconnect() {
        socketService.disconnect()
    }
}