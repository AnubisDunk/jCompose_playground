package com.anubisdunk.mvvm.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var titleText by mutableStateOf("Playground")
    var userInput by mutableStateOf("")


}