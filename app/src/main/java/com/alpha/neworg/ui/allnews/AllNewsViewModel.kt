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




    fun test(){
        CoroutineScope(Dispatchers.IO).launch {
           articleRepo.getAllArticles()
            }

        }
    }


}