package com.appsv.food_hub.ui.feature.order_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.food_hub.data.FoodApi
import com.appsv.food_hub.data.models.Order
import com.appsv.food_hub.data.remote.ApiResponse
import com.appsv.food_hub.data.remote.safeApiCall
import com.appsv.food_hub.utils.OrdersUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersListViewModel @Inject constructor(val foodApi: FoodApi) : ViewModel() {

    fun getOrderTypes(): List<String> {
        val types = OrdersUtils.OrderStatus.entries.map { it.name }
        return types
    }

    private val _uiState = MutableStateFlow<OrdersScreenState>(OrdersScreenState.Loading)
    val uiState = _uiState.asStateFlow()
    fun getOrdersByType(status: String) {
        viewModelScope.launch {
            _uiState.value = OrdersScreenState.Loading
            val response = safeApiCall { foodApi.getRestaurantOrders(status) }
            when (response) {
                is ApiResponse.Success -> {
                    _uiState.value = OrdersScreenState.Success(response.data.orders)
                }

                else -> {
                    _uiState.value = OrdersScreenState.Failed
                }
            }
        }
    }

    sealed class OrdersScreenState {
        object Loading : OrdersScreenState()
        object Failed : OrdersScreenState()
        data class Success(val data: List<Order>) : OrdersScreenState()
    }
}