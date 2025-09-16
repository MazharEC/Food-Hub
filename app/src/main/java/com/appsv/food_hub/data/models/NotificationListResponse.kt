package com.appsv.food_hub.data.models

data class NotificationListResponse(
    val notifications: List<Notification>,
    val unreadCount: Int
)