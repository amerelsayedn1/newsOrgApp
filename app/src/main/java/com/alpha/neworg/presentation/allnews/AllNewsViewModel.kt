package com.alpha.neworg.presentation.allnews

import androidx.lifecycle.MutableLiveData
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.data.networking.repository.ArticleRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllNewsViewModel(private val articleRepos: ArticleRepo) {

    val data: MutableLiveData<ArrayList<ItemModel>> = MutableLiveData()


    fun getAllArticles() {

        CoroutineScope(Dispatchers.Main).launch {
            val response = articleRepos.getAllArticles()
            data.value = response.body()!!.articles
        }

    }
}


