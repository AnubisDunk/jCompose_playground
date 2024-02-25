package com.anubisdunk.mvvm.playground

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RevApi {
    @Headers("Currency: EUR")
    @GET("{store}")
    suspend fun getSkin(
        @Path("store") id : String
    ) : DataItems


    @GET(".")
    suspend fun getStores() : List<Store>
}