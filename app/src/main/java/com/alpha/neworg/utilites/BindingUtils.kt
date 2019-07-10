package com.alpha.neworg.utilites

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alpha.neworg.R
import com.bumptech.glide.Glide


object BindingUtils {

    /* fun convertToSuffix(count: Long): String {
         if (count < 1000) return "" + count
         val exp = (Math.log(count.toDouble()) / Math.log(1000.0)).toInt()
         return String.format(
             "%.1f%c",
             count / Math.pow(1000.0, exp.toDouble()),
             "kmgtpe"[exp - 1]
         )
     }*/

    /*@BindingAdapter("imageurl")
    @JvmStatic
    fun setImageByRes(view: ImageView, imageUrl: String) {
        Glide.with(view.context).load("http://tepci.xyz/public/$imageUrl").placeholder(R.mipmap.tepci_logo).into(view)
        Log.e("TTTT",imageUrl+"Empty_Image")
    }*/

    /*@BindingAdapter(value = ["android:src"], requireAll = false)
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(view.context).load("http://tepci.xyz/public/$url").placeholder(R.mipmap.tepci_green_logo).into(view)
        }

    }*/


    @BindingAdapter("bind:src")
    @JvmStatic
    fun setimgresource(view: ImageView, url: String) {
        Glide.with(view.context).load(url).placeholder(R.mipmap.splash_logo).into(view)
    }


}