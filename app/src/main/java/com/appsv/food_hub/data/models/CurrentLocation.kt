package com.appsv.food_hub.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CurrentLocation(
    val address: String,
    val latitude: Double,
    val longitude: Double
)