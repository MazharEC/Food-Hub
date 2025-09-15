package com.appsv.food_hub.data.models

data class ConfirmPaymentRequest(
    val paymentIntentId: String,
    val addressId: String
)