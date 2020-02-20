package com.alpha.neworg.data.repository

import androidx.lifecycle.MutableLiveData
import com.alpha.bookapplication.data.networking.baseRequest.Network
import com.alpha.neworg.data.model.BaseModel
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.data.networking.RetroClient
import com.alpha.neworg.utilites.ConstantUtils
import retrofit2.Response


object ArticleRepo {

    private val provideApi = RetroClient.provideApi()

    fun getAllArticles(): MutableLiveData<ArrayList<ItemModel>> {
        val data = MutableLiveData<ArrayList<ItemModel>>()
        Network.request(

            request = {
                provideApi.getPosts(ConstantUtils.country,ConstantUtils.category, ConstantUtils.api_key)
            },

            success = {
                data.value = it.articles
            },

            error = {

            }

        )
        return data

    }

}