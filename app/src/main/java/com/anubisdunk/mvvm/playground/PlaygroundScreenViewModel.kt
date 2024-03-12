package com.anubisdunk.mvvm.playground

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DecimalFormat

class PlaygroundScreenViewModel : ViewModel() {

    private val _items = MutableStateFlow(listOf<Item>())
    val items = _items.asStateFlow()

    private val _stores = MutableStateFlow(listOf<Store>())
    val stores = _stores.asStateFlow()

    private val BASE_URL = "https://rust.scmm.app/api/store/"
    var storeId by mutableStateOf("")
    private var iterator = 0
    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RevApi::class.java)

    init {
        getStores()
        getItems("current")
    }

    fun getStores() {
        viewModelScope.launch {
            val stores = api.getStores()
            _stores.value = stores.take(11).drop(1)
        }
    }

    fun getItems(id: String) {
        _items.value = emptyList()
        storeId = id
        viewModelScope.launch {
            val skins = api.getSkin(id)
            val newList = mutableListOf<Item>()

            for (item in skins.items) {
                val newItem = Item(
                    name = item.name,
                    creatorName = item.creatorName,
                    itemType = item.itemType,
                    iconUrl = item.iconUrl,
                    revenue = calcRevenue(item)
                )
                if (newItem.revenue != ".00") {
                    newList += newItem
                }

            }
            val sorted = newList.sortedByDescending { it.revenue.toFloat() }
            _items.value = sorted
        }
    }

    fun cycleStore(next: Boolean) {
        if (next) {
            if (iterator+1 != 10){
                iterator++
            } else {
                iterator = 0
            }
        } else {
            if (iterator-1 < 0){
                iterator = 9
            } else {
                iterator --
            }
        }
        if(_stores.value.isNotEmpty()){
            getItems(_stores.value[iterator].id)
        }
    }

    fun calcRevenue(item: Skin): String {
        val price = (item.storePrice / 100).toBigDecimal()
        val count = item.subscriptions.toBigDecimal()
        return try {
            val doubleDecimal = DecimalFormat("#.00")
            doubleDecimal.format(price * count * 0.25f.toBigDecimal()).toString()
        } catch (e: Exception) {
            ("error")

        }
    }
}