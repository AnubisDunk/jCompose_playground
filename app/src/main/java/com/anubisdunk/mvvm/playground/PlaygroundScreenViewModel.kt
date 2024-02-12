package com.anubisdunk.mvvm.playground

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlaygroundScreenViewModel : ViewModel() {

    private val _item = MutableStateFlow("")
    val item = _item.asStateFlow()
    private val _items = MutableStateFlow(listOf<String>())
    val items : StateFlow<List<String>> = _items

    fun updateUserItem(input: String) {
        _item.value = input
    }
    fun addItem(item: String) {
        _items.value += item
    }
}