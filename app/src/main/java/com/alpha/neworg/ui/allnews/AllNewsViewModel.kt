package com.alpha.neworg.ui.allnews

import androidx.lifecycle.ViewModel
import com.alpha.neworg.data.networking.repository.ArticleRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllNewsViewModel(private val articleRepo: ArticleRepo) : ViewModel() {


    fun getAllArticles() {
        CoroutineScope(Dispatchers.Main).launch {
            articleRepo.getAllArticles()
        }

    }
}


