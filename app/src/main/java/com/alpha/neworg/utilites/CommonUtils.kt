

package com.alpha.neworg.utilites

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.util.Log
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.util.*
import android.net.NetworkCapabilities










/**
 * Created by Amer Elsayed on 27/4/19.
 */

@Suppress("SENSELESS_COMPARISON")
object CommonUtils {



    /*Recycle Animation*/
    fun runReycleAnimation(recycleView: RecyclerView, anim_res: Int) {
        val content = recycleView.context
        val layoutAnimationController = AnimationUtils.loadLayoutAnimation(content, anim_res)
        recycleView.layoutAnimation = layoutAnimationController
        recycleView.adapter!!.notifyDataSetChanged()
        recycleView.scheduleLayoutAnimation()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun setLocale(old: Context, locale: Locale): Context {
        val oldConfig = old.resources.configuration
        oldConfig.setLocale(locale)
        return old.createConfigurationContext(oldConfig)
    }



    /*To check Validation*/



    @Suppress("DEPRECATION")
    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        } else {
            connectivityManager.activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI
        }
    }





    /*Error Message*/
    fun errorSnackBar(context: Context, view: View, Message: String, font: Int) {
        val snackBar = Snackbar.make(view, Message, Snackbar.LENGTH_SHORT)
        val tvMsg = snackBar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        val typeface = ResourcesCompat.getFont(context, font)
        tvMsg.typeface = typeface
        snackBar.show()
    }


    /*ُEmail Error Message*/
    fun isEmailValid(email: CharSequence): Boolean {
        return !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    /*To check if fragment is visible*/
    fun isVisible(context: AppCompatActivity, fragment_container: Int, fragment_tag: String, fragment: Fragment) {
        val fragment_main = context.supportFragmentManager.findFragmentByTag(fragment_tag)
        if (fragment_main != null && fragment_main.isVisible) {
            Log.e("Fragment_is_visible", "Visible")
        } else {
            clearStack(context)
            context.supportFragmentManager.beginTransaction().replace(fragment_container, fragment, fragment_tag)
                .commit()
        }
    }


    /*To Clear Back Stack*/
    fun clearStack(context: AppCompatActivity) {
        val backStackEntry = context.supportFragmentManager.backStackEntryCount
        if (backStackEntry > 0) {
            for (i in 0 until backStackEntry)
                context.supportFragmentManager.popBackStackImmediate()
        }

        if (context.supportFragmentManager.fragments != null && context.supportFragmentManager.fragments.size > 0) {
            for (i in 0 until context.supportFragmentManager.fragments.size) {
                val fragment = context.supportFragmentManager.fragments[i]
                if (fragment != null)
                    context.supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }
    }



    /*fun isWiFiConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (cm != null) {
            if (Build.VERSION.SDK_INT < 23) {
                val ni = cm.activeNetworkInfo

                if (ni != null) {
                    return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
                }
            } else {
                val n = cm.activeNetwork

                if (n != null) {
                    val nc = cm.getNetworkCapabilities(n)

                    return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                        NetworkCapabilities.TRANSPORT_WIFI
                    )
                }
            }
        }

        return false
    }


    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (cm != null) {
            if (Build.VERSION.SDK_INT < 23) {
                val ni = cm.activeNetworkInfo

                if (ni != null) {
                    return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
                }
            } else {
                val n = cm.activeNetwork

                if (n != null) {
                    val nc = cm.getNetworkCapabilities(n)

                    return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                        NetworkCapabilities.TRANSPORT_WIFI
                    )
                }
            }
        }

        return false
    }*/




}