package com.alpha.neworg.data.networking.repository

import com.alpha.neworg.data.RetroClient
import com.alpha.neworg.utilites.ConstantUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import com.alpha.neworg.data.model.BaseModel
import com.alpha.neworg.data.model.ItemModel
import retrofit2.Response


class ArticleRepo {


    suspend fun getAllArticles()/*: Response<BaseModel<ArrayList<ItemModel>>>*/ {

        val service = RetroClient.getClient()


        val response = service.getPosts(ConstantUtils.source, ConstantUtils.api_key)
        withContext(Dispatchers.Main) {
            try {
                if (response.isSuccessful) {


                } else {

                }
            } catch (e: HttpException) {
                // Toast.makeText(this@SplashActivity, "ewrt", Toast.LENGTH_LONG).show()
            } catch (e: Throwable) {
                // Toast.makeText(this@SplashActivity, "ewrt", Toast.LENGTH_LONG).show()
            }

        }
    }

}