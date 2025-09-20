package com.appsv.food_hub.data.repository

import com.appsv.food_hub.data.SocketService
import javax.inject.Inject

class CustomerLocationUpdateSocketRepository @Inject constructor(private val socketService: SocketService) :
    LocationUpdateBaseRepository(socketService) {

    fun connect(orderID: String, riderID: String) {
        try {
            socketService.connect(
                orderID, riderID, null, null
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    fun disconnect() {
        socketService.disconnect()
    }
}