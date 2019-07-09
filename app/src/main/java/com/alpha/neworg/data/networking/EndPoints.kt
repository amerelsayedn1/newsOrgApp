package com.alpha.neworg.data.networking

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoints {

    /*?=techcrunch&=*/

    @GET("v2/top-headlines")
    suspend fun getPosts(@Query("sources") sources: String,@Query("apiKey") apiKey: String): Response<List<String>>

}