package com.alpha.neworg.presentation.newsdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.alpha.neworg.R
import com.alpha.neworg.core.BaseActivity
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.databinding.ActivityDetailsNewsBinding
import kotlinx.android.synthetic.main.toolbar_layout.*

class NewsDetailsActivity : BaseActivity<NewsDetailsViewModel, ActivityDetailsNewsBinding>(
    NewsDetailsViewModel::class.java,
    R.layout.activity_details_news
) {

    companion object {
        fun getStartIntent(context: Context, model: ItemModel): Intent {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra("extra", model)
            return intent
        }
    }

    override val useDrawer = false

    override val enableBack = true


    override fun initViewModel(viewModel: NewsDetailsViewModel) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_main)
        val newsDetails: ItemModel? = intent.getParcelableExtra("extra")
        newsDetails?.let {
            binding.model = it
        }
    }

}
