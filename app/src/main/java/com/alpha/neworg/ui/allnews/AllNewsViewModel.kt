package com.alpha.neworg.ui.allnews

import androidx.lifecycle.ViewModel
import com.alpha.neworg.data.networking.repository.ArticleRepo

class AllNewsViewModel(private val articleRepo: ArticleRepo) : ViewModel() {

    fun getAllArticles()/*: Response<BaseModel<ArrayList<ItemModel>>>*/ {
         articleRepo.getAllArticles()
    }


}