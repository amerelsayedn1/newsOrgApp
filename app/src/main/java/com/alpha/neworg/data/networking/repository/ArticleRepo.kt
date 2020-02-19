package com.alpha.neworg.data.networking.repository

import com.alpha.neworg.data.model.BaseModel
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.data.networking.RetroClient
import com.alpha.neworg.utilites.ConstantUtils
import retrofit2.Response


class ArticleRepo {

    suspend fun getAllArticles(): Response<BaseModel<ArrayList<ItemModel>>> {
        val service = RetroClient.provideApi()
        return service.getPosts(ConstantUtils.source, ConstantUtils.api_key)
    }

}