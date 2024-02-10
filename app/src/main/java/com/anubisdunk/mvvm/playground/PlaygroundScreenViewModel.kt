package com.anubisdunk.mvvm.playground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PlaygroundScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(0)

    var item by mutableStateOf("")
        private set
    var items by mutableStateOf(listOf<String>())

    fun updateUserItem(input: String){
        item = input
    }

    fun addItem(item : String) {
        items += item
    }
}