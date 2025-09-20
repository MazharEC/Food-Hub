package com.appsv.food_hub.ui.features.orders

import com.appsv.food_hub.data.SocketService


abstract class LocationUpdateBaseRepository (val socketService: SocketService)
{
    open val messages = socketService.messages
    abstract fun connect(orderID: String, riderID: String)
    abstract fun disconnect()
}