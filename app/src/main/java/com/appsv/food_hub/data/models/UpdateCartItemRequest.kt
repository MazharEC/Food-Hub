package com.appsv.food_hub.data.models

data class UpdateCartItemRequest(
    val cartItemId: String,
    val quantity: Int
)