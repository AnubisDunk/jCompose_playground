package com.anubisdunk.mvvm.retrofitJokes.api

import com.anubisdunk.mvvm.retrofitJokes.model.Joke
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface JokesApi {
    @Headers("Accept: application/json")
    @GET(".")
    suspend fun getJoke(): Joke

}
