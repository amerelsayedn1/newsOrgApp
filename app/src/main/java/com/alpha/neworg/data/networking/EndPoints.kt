package com.alpha.neworg.data.networking

import com.alpha.neworg.data.model.BaseModel
import com.alpha.neworg.data.model.ItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoints {

    @GET("v2/top-headlines")
    suspend fun getPosts(@Query("country") country: String,@Query("category") category: String,@Query("apiKey") apiKey: String): Response<BaseModel<ArrayList<ItemModel>>>

}