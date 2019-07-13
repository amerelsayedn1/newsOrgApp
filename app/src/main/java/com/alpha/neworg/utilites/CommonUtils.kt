

package com.alpha.neworg.utilites

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.view.*
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import android.net.NetworkCapabilities


/**
 * Created by Amer Elsayed on 27/4/19.
 */

@Suppress("SENSELESS_COMPARISON")
object CommonUtils {

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


}