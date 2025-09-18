package com.appsv.food_hub.utils

object OrdersUtils {

    enum class OrderStatus {
        ASSIGNED,         // Rider assigned
        OUT_FOR_DELIVERY, // Rider picked up
        DELIVERED,        // Order completed
        REJECTED,         // Restaurant rejected the order
        CANCELLED         // Customer cancelled
    }
}
