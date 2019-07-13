package com.alpha.neworg.utilites

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alpha.neworg.R
import com.bumptech.glide.Glide


object BindingUtils {

    @BindingAdapter("bind:src")
    @JvmStatic
    fun setimgresource(view: ImageView, url: String) {
        Glide.with(view.context).load(url).placeholder(R.mipmap.splash_logo).into(view)
    }


}