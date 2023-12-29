package com.anubisdunk.mvvm.retrofitJokes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anubisdunk.mvvm.retrofitJokes.repo.JokesRepo
import kotlinx.coroutines.launch

class JokesViewModel(val jokeRepo: JokesRepo) : ViewModel() {

    var themeInput by mutableStateOf("")


    var jokeState by mutableStateOf("")

//    private val _jokeState = MutableStateFlow(Joke("Ahahahah"))
//    val jokeState: StateFlow<Joke>
//        get() = _jokeState

    fun fetchJoke() {

        viewModelScope.launch {
            val joke = jokeRepo.getJoke()
            jokeState = joke.joke
        }


    }
}