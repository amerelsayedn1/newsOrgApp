package com.alpha.neworg.presentation.newsdetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.widget.Toolbar
import com.alpha.neworg.BR
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.databinding.ActivityDetailsNewsBinding
import kotlinx.android.synthetic.main.toolbar_layout.*

class NewsDetailsActivity:BaseActivity<ActivityDetailsNewsBinding>() {

    companion object {
        fun getStartIntent(context: Context,model:ItemModel): Intent {
            val intent=Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra("extra",model)
            return intent
        }
    }


    override val layoutId: Int
        get() = R.layout.activity_details_news

    override val isFullScreen: Boolean
        get() = false

    override val hideInputType: Boolean
        get() = true

    override val enableBack: Boolean
        get() = true

    override val toolbar: Toolbar?
        get() = toolbar_main

    override fun setUp() {
        val extraModel=intent.getSerializableExtra("extra") as ItemModel
        getViewDataBinding().setVariable(BR.model,extraModel)
    }
}