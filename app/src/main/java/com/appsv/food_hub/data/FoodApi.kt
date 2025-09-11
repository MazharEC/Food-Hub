package com.appsv.food_hub.data

import com.appsv.food_hub.data.models.AuthResponse
import com.appsv.food_hub.data.models.SignInRequest
import com.appsv.food_hub.data.models.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodApi {
    @GET("/food")
    suspend fun getFood(): List<String>

    @POST("/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): AuthResponse

    @POST("/auth/login")
    suspend fun signIn(@Body request: SignInRequest): AuthResponse


}