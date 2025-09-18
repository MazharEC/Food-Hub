package com.appsv.food_hub.data.models

data class DeliveryOrderItem(
    val id: String,
    val name: String,
    val price: Double,
    val quantity: Int
)