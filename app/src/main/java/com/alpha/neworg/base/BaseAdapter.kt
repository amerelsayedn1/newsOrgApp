package com.alpha.balleh.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private val data:ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    abstract fun dataBindingUtil(parent: ViewGroup): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return dataBindingUtil(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}