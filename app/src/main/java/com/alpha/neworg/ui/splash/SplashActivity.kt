package com.alpha.neworg.ui.splash

import androidx.appcompat.widget.Toolbar
import com.alpha.neworg.R
import com.alpha.neworg.base.BaseActivity
import com.alpha.neworg.databinding.ActivitySplashBinding
import com.alpha.neworg.ui.allnews.AllNewActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : BaseActivity<ActivitySplashBinding>(),CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

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

        launch {
            delay(3000)
            withContext(Dispatchers.Main){
               startActivity(AllNewActivity.getStartIntent(this@SplashActivity))
                finishAffinity()
            }
        }

    }


}