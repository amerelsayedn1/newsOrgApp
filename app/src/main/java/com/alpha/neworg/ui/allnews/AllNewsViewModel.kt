package com.alpha.neworg.ui.allnews

import androidx.lifecycle.ViewModel
import com.alpha.neworg.data.networking.repository.ArticleRepo
import com.alpha.neworg.utilites.ConstantUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class AllNewsViewModel(private val articleRepo: ArticleRepo) : ViewModel() {

    fun getAllArticles()/*: Response<BaseModel<ArrayList<ItemModel>>>*/ {
         articleRepo.getAllArticles()
    }


    fun test(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getPosts(ConstantUtils.source, ConstantUtils.api_key)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {

                        response_dtat = response

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


}