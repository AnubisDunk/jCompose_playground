package com.anubisdunk.mvvm.retrofitJokes

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anubisdunk.mvvm.retrofitJokes.model.Joke
import com.anubisdunk.mvvm.retrofitJokes.repo.JokesRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JokesViewModel(val jokeRepo: JokesRepo) : ViewModel() {

    private val _jokes = MutableStateFlow(emptyList<Joke>())
    val jokes: StateFlow<List<Joke>>
        get() = _jokes

    fun fetchJoke() {
        viewModelScope.launch {
            val joke = jokeRepo.getJoke()
            _jokes.value += joke
            Log.d("Log", _jokes.value.toString())
        }


    }
}