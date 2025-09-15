package com.appsv.food_hub.data

import com.appsv.food_hub.data.models.AddToCartRequest
import com.appsv.food_hub.data.models.AddToCartResponse
import com.appsv.food_hub.data.models.Address
import com.appsv.food_hub.data.models.AddressListResponse
import com.appsv.food_hub.data.models.AuthResponse
import com.appsv.food_hub.data.models.CartResponse
import com.appsv.food_hub.data.models.CategoriesResponse
import com.appsv.food_hub.data.models.ConfirmPaymentRequest
import com.appsv.food_hub.data.models.ConfirmPaymentResponse
import com.appsv.food_hub.data.models.FoodItemResponse
import com.appsv.food_hub.data.models.GenericMsgResponse
import com.appsv.food_hub.data.models.OAuthRequest
import com.appsv.food_hub.data.models.Order
import com.appsv.food_hub.data.models.OrderListResponse
import com.appsv.food_hub.data.models.PaymentIntentRequest
import com.appsv.food_hub.data.models.PaymentIntentResponse
import com.appsv.food_hub.data.models.ResturauntsResponse
import com.appsv.food_hub.data.models.ReverseGeoCodeRequest
import com.appsv.food_hub.data.models.SignInRequest
import com.appsv.food_hub.data.models.SignUpRequest
import com.appsv.food_hub.data.models.UpdateCartItemRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {
    @GET("/categories")
    suspend fun getCategories(): Response<CategoriesResponse>

    @GET("/restaurants")
    suspend fun getRestaurants(
        @Query("lat") lat: Double, @Query("lon") lon: Double
    ): Response<ResturauntsResponse>

    @POST("/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): AuthResponse

    @POST("/auth/login")
    suspend fun signIn(@Body request: SignInRequest): AuthResponse

    @POST("/auth/oauth")
    suspend fun oAuth(@Body request: OAuthRequest): Response<AuthResponse>

    @GET("/restaurants/{restaurantId}/menu")
    suspend fun getFoodItemForRestaurant(@Path("restaurantId") restaurantId: String): Response<FoodItemResponse>

    @POST("/cart")
    suspend fun addToCart(@Body request: AddToCartRequest): Response<AddToCartResponse>

    @GET("/cart")
    suspend fun getCart(): Response<CartResponse>

    @PATCH("/cart")
    suspend fun updateCart(@Body request: UpdateCartItemRequest): Response<GenericMsgResponse>

    @DELETE("/cart/{cartItemId}")
    suspend fun deleteCartItem(@Path("cartItemId") cartItemId: String): Response<GenericMsgResponse>

    @GET("/addresses")
    suspend fun getUserAddress(): Response<AddressListResponse>

    @POST("/addresses/reverse-geocode")
    suspend fun reverseGeocode(@Body request: ReverseGeoCodeRequest): Response<Address>

    @POST("/addresses")
    suspend fun storeAddress(@Body address: Address): Response<GenericMsgResponse>

    @POST("/payments/create-intent")
    suspend fun getPaymentIntent(@Body request: PaymentIntentRequest): Response<PaymentIntentResponse>

    @POST("/payments/confirm/{paymentIntentId}")
    suspend fun verifyPurchase(
        @Body request: ConfirmPaymentRequest, @Path("paymentIntentId") paymentIntentId: String
    ): Response<ConfirmPaymentResponse>

    @GET("/orders")
    suspend fun getOrders(): Response<OrderListResponse>

    @GET("/orders/{orderId}")
    suspend fun getOrderDetails(@Path("orderId") orderId: String): Response<Order>

}