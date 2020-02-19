package com.alpha.neworg.presentation.allnews

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alpha.neworg.BR
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.data.networking.repository.ArticleRepo
import com.alpha.neworg.databinding.ActivityAllNewsBinding
import com.alpha.neworg.presentation.allnews.adapter.AllNewsRecycleAdapter
import com.alpha.neworg.presentation.newsdetails.NewsDetailsActivity
import com.alpha.neworg.utilites.CommonUtils
import kotlinx.android.synthetic.main.activity_all_news.*
import kotlinx.android.synthetic.main.toolbar_layout.*


class AllNewActivity : BaseActivity<ActivityAllNewsBinding>(), AllNewsRecycleAdapter.CallBack {

    private lateinit var viewmodel: AllNewsViewModel
    private lateinit var allArticleRepo: ArticleRepo
    private var data: ArrayList<ItemModel>? = null

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AllNewActivity::class.java)
        }
    }

    override val layoutId = R.layout.activity_all_news

    override val isFullScreen= false

    override val hideInputType = true

    override val enableBack = true

    override val toolbar: Toolbar?
        get() = toolbar_main

    override fun setUp() {

        allArticleRepo = ArticleRepo()
        viewmodel = AllNewsViewModel(allArticleRepo)
        setAdapter()

        viewmodel.getAllArticles()
        getViewDataBinding().setVariable(BR.loading, true)

        viewmodel.data.observe(this, Observer {

            getViewDataBinding().setVariable(BR.loading, false)

            data = it


        })

    }


    override fun onItemClicked(view: View, position: Int) {
        startActivity(NewsDetailsActivity.getStartIntent(this, data!![position]))
    }


    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(this)
        getViewDataBinding().rvData.layoutManager = linearLayoutManager
        val adapter = AllNewsRecycleAdapter(arrayListOf())
        getViewDataBinding().rvData.adapter = adapter
        adapter.setOnCallBack(this)
    }
}