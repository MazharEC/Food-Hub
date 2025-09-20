package com.appsv.food_hub.data.models

import kotlinx.serialization.Serializable

@Serializable
data class NextStop(
    val address: String,
    val latitude: Double,
    val longitude: Double
)