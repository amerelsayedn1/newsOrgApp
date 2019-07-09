package com.alpha.neworg.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.alpha.neworg.R
import com.alpha.neworg.utilites.CommonUtils


@Suppress("SENSELESS_COMPARISON")
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    private var viewDataBinding: T? = null
    abstract val layoutId: Int
    abstract val isFullScreen: Boolean
    abstract val hideInputType: Boolean
    abstract val enableBack: Boolean
    abstract val toolbar: Toolbar?

    protected abstract fun setUp(savedInstanceState: Bundle)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

        /** To make Full Screen */
        if (isFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }


        /** Hide softKeyboard*/
        if (hideInputType) {
            hideKeyboard()
        }


        super.onCreate(savedInstanceState, persistentState)


        /** execute binding */
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)


        /** setup view */
        setUp(savedInstanceState!!)


        /** toolbar config */
        configureToolbar(toolbar!!, R.mipmap.baseline_arrow_back_white_36)


    }

    fun getViewDataBinding(): T {
        return viewDataBinding!!
    }

    /** Toolbar Config*/
    private fun configureToolbar(toolbar: Toolbar, backIcon: Int) {

        setSupportActionBar(toolbar)

        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        supportActionBar!!.title = null
        // check if enable back
        if (enableBack) {
            // set the back icon
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            toolbar.setNavigationIcon(backIcon)
            //tv_title.text = title()
        }
    }

    /** Function to hide keyboard*/
    private fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = this.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    /** handle back press*/
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    val isNetworkConnected: Boolean
        get() = CommonUtils.isNetworkConnected(applicationContext)

    /**To check if has Permission*/
    protected fun hasPermissions(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true
        return permissions.none {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
    }

    /**To Request Permissions*/
    protected fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

}