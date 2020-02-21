package com.alpha.neworg.presentation.allnews

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alpha.neworg.R
import com.alpha.neworg.core.BaseActivity
import com.alpha.neworg.core.BaseAdapter
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.databinding.ActivityAllNewsBinding
import com.alpha.neworg.presentation.allnews.adapter.AllNewsRecycleAdapter
import com.alpha.neworg.presentation.newsdetails.NewsDetailsActivity
import kotlinx.android.synthetic.main.toolbar_layout.*


class AllNewActivity :
    BaseActivity<AllNewsViewModel, ActivityAllNewsBinding>(
        AllNewsViewModel::class.java,
        R.layout.activity_all_news
    ), BaseAdapter.OnItemClickedListener<ItemModel> {

    private lateinit var newAdapter: AllNewsRecycleAdapter
    private lateinit var viewModel: AllNewsViewModel

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AllNewActivity::class.java)
        }
    }

    override val enableBack = false

    override val useDrawer = false

    override fun initViewModel(viewModel: AllNewsViewModel) {
        this.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_main)
        initNews()

        viewModel.getArticles().observe(this, Observer {
            newAdapter.updateItems(it)
        })

    }

    private fun initNews() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvData.layoutManager = linearLayoutManager
        newAdapter = AllNewsRecycleAdapter(arrayListOf())
        binding.rvData.adapter = newAdapter
        newAdapter.setOnItemClickListener(this)
    }

    override fun onItemClickListener(view: View, model: ItemModel) {
        startActivity(NewsDetailsActivity.getStartIntent(this, model))
    }

}