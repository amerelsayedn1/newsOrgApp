package com.alpha.neworg.presentation.allnews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alpha.neworg.core.BaseAdapter
import com.alpha.neworg.core.BaseViewHolder
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.databinding.RecycleHomeRowItemBinding

class AllNewsRecycleAdapter(val data: ArrayList<ItemModel>) : BaseAdapter<ItemModel>(data) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        holder.bind(data[position])
    }

    override fun rowBinding(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            RecycleHomeRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    inner class ViewHolder(private val item: RecycleHomeRowItemBinding) : BaseViewHolder<ItemModel>(item) {

        override fun bind(data: ItemModel) {
            item.model = data
            item.position = adapterPosition
            item.itemClick = onItemClicked
        }

    }

}


