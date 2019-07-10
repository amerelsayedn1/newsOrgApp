package com.alpha.neworg.data.networking.repository

import com.alpha.neworg.data.RetroClient
import com.alpha.neworg.utilites.ConstantUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.alpha.neworg.data.model.BaseModel
import com.alpha.neworg.data.model.ItemModel
import retrofit2.Response


class ArticleRepo {


    suspend fun getAllArticles(): Response<BaseModel<ArrayList<ItemModel>>> {

        val service = RetroClient.getClient()

        return withContext(Dispatchers.IO) {
            service.getPosts(ConstantUtils.source, ConstantUtils.api_key)
        }

    }

}