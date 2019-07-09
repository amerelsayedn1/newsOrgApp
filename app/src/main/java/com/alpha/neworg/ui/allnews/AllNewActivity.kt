package com.alpha.neworg.ui.allnews

import androidx.appcompat.widget.Toolbar
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.databinding.ActivityAllNewsBinding
import kotlinx.android.synthetic.main.toolbar_layout.*

class AllNewActivity:BaseActivity<ActivityAllNewsBinding>() {

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

    }
}