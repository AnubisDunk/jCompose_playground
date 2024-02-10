package com.anubisdunk.mvvm.playground

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PlaygroundScreenViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(0)

}