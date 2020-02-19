package com.alpha.neworg.utilites

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar


inline fun View.snack(
    @StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit
) {
    snack(resources.getString(messageRes), length, f)
}

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

inline fun String.snack(
    view: View,
    font: Int?,
    length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit
) {
    val snack = Snackbar.make(view, this, length)

    val tvMsg = snack.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    tvMsg.textSize = 12f
    val tvAction =
        snack.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
    tvAction.textSize = 10f

    font?.let {
        val typeface = ResourcesCompat.getFont(view.context, it)
        tvMsg.typeface = typeface
        tvAction.typeface = typeface
    }

    snack.f()
    snack.show()
}

fun String.snack(view: View, font: Int?, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(view, this, length)
    val tvMsg = snack.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)


    font?.let {
        val typeface = ResourcesCompat.getFont(view.context, it)
        tvMsg.typeface = typeface

    }


    snack.show()
}


fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}
