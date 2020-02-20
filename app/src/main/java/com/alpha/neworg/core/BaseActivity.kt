package com.alpha.neworg.core

import android.os.Bundle
import android.view.Menu
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.alpha.neworg.R


abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(private val mViewModelClass: Class<VM>, @LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    private var menuId: Int = 0

    abstract val enableBack: Boolean
    abstract val useDrawer: Boolean

    private val viewModel by lazy {
        ViewModelProvider(this).get(mViewModelClass)
    }

    /** handle back press*/
    override fun onSupportNavigateUp(): Boolean {

        if (enableBack) {
            onBackPressed()
        }

        return true
    }

    val binding by lazy {
        DataBindingUtil.setContentView(this, layoutResId) as DB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel(viewModel)
        super.onCreate(savedInstanceState)
        binding
    }

    fun createOptionsMenu(menuId: Int) {
        this.menuId = menuId
        invalidateOptionsMenu()
    }

    /**
     * function is used to create a menu
     */
    fun removeOptionsMenu() {
        menuId = 0
        invalidateOptionsMenu()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (menuId != 0) {
            menuInflater.inflate(menuId, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }


    /**
     *
     *  You need override this method.
     *  And you need to set viewModel to binding: binding.viewModel = viewModel
     *
     */
    abstract fun initViewModel(viewModel: VM)

    override fun setSupportActionBar(toolbar: Toolbar?) {

        super.setSupportActionBar(toolbar)

        toolbar?.let {
            it.setTitleTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            supportActionBar?.title = null

            if (enableBack) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
                supportActionBar?.setDisplayShowTitleEnabled(false)
            }

            if (useDrawer) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
                supportActionBar?.setDisplayShowTitleEnabled(false)
                //toolbar.setNavigationIcon(R.drawable.ic_menu)
            }

        }

    }


}