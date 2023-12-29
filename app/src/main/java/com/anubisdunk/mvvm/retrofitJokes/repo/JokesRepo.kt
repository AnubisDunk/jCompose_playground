package com.anubisdunk.mvvm.retrofitJokes.repo

import com.anubisdunk.mvvm.retrofitJokes.api.JokesApi
import com.anubisdunk.mvvm.retrofitJokes.model.Joke

class JokesRepo(private val jokesApi: JokesApi){
    suspend fun getJoke(): Joke {
        return jokesApi.getJoke()
    }
}