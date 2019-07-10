package com.alpha.neworg.ui.allnews

import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.data.networking.repository.ArticleRepo
import com.alpha.neworg.databinding.ActivityAllNewsBinding
import com.alpha.neworg.ui.allnews.adapter.AllNewsRecycleAdapter
import kotlinx.android.synthetic.main.toolbar_layout.*

class AllNewActivity : BaseActivity<ActivityAllNewsBinding>() {

    private lateinit var viewmodel: AllNewsViewModel
    private lateinit var allArticleRepo: ArticleRepo


    override val layoutId: Int
        get() = R.layout.activity_all_news

    override val isFullScreen: Boolean
        get() = false

    override val hideInputType: Boolean
        get() = true

    override val enableBack: Boolean
        get() = true

    override val toolbar: Toolbar?
        get() = toolbar_main

    override fun setUp() {

        allArticleRepo = ArticleRepo()
        viewmodel = AllNewsViewModel(allArticleRepo)
        viewmodel.getAllArticles()

        viewmodel.data.observe(this, Observer {

            val linearLayoutManager = LinearLayoutManager(this)
            getViewDataBinding().rvData.layoutManager = linearLayoutManager
            val adapter = AllNewsRecycleAdapter(it)
            getViewDataBinding().rvData.adapter = adapter

            Toast.makeText(this,it.size.toString(),Toast.LENGTH_LONG).show()
        })

    }
}