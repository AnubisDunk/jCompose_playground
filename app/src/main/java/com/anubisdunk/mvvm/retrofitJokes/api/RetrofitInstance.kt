package com.anubisdunk.mvvm.retrofitJokes.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    fun provideApi(builder: Retrofit.Builder) : JokesApi {
        return builder
            .build()
            .create(JokesApi::class.java)
    }

    fun provideRetrofit(): Retrofit.Builder{
        return  Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com/")
            .addConverterFactory(GsonConverterFactory.create())
    }
}