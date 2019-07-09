package com.alpha.neworg.ui.splash

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val isFullScreen: Boolean
        get() = true

    override val hideInputType: Boolean
        get() = false

    override val enableBack: Boolean
        get() = false

    override val toolbar: Toolbar?
        get() = null

    override fun setUp(savedInstanceState: Bundle) {

    }
}