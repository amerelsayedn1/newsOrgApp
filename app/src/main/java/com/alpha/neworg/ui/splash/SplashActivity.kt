package com.alpha.neworg.ui.splash

import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.data.RetroClient
import com.alpha.neworg.databinding.ActivitySplashBinding
import com.alpha.neworg.utilites.ConstantUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

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

    override fun setUp() {









    }




}