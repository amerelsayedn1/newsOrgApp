package com.alpha.neworg.core

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private var items: ArrayList<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var onItemClicked: OnItemClickedListener<T>? = null

    interface OnItemClickedListener<T> {
        fun onItemClickListener(view: View, model: T)
    }

    fun setOnItemClickListener(onItemClicked: OnItemClickedListener<T>) {
        this.onItemClicked = onItemClicked
    }


    abstract fun rowBinding(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return rowBinding(parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    fun updateItems(data: ArrayList<T>) {
        this.items.clear()
        this.items.addAll(data)
        notifyDataSetChanged()
    }

    fun deleteAll() {
        items.clear()
        notifyDataSetChanged()
    }
}