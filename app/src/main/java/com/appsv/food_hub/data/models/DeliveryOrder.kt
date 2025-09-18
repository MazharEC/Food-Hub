package com.appsv.food_hub.data.models

import com.stripe.android.model.Customer

data class DeliveryOrder(
    val createdAt: String,
    val customer: Customer,
    val estimatedEarning: Double,
    val items: List<DeliveryOrderItem>,
    val orderId: String,
    val restaurant: Restaurant,
    val status: String,
    val totalAmount: Double,
    val updatedAt: String
)