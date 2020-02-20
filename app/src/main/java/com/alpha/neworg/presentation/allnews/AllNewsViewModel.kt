package com.alpha.neworg.presentation.allnews

import androidx.lifecycle.MutableLiveData
import com.alpha.neworg.core.BaseViewModel
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.data.repository.ArticleRepo.getAllArticles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllNewsViewModel : BaseViewModel() {

    val data: MutableLiveData<ArrayList<ItemModel>> = MutableLiveData()


    fun getArticles(): MutableLiveData<ArrayList<ItemModel>> {
        return getAllArticles()
    }
}


