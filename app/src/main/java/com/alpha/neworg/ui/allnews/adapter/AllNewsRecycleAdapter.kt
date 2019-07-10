package com.alpha.neworg.ui.allnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alpha.neworg.data.model.ItemModel
import com.alpha.neworg.databinding.RecycleHomeRowItemBinding

class FavoriteRecycleAdapter(val data: ArrayList<ItemModel>) : RecyclerView.Adapter<FavoriteRecycleAdapter.ViewHolder>() {





    interface CallBack {
        fun onItemClicked(view: View, position: Int)
        fun onRemoveItem(view: View, position: Int)
    }

    private var callback: CallBack? = null

    fun setOnCallBack(callback: CallBack) {
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecycleHomeRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class ViewHolder(private val item: RecycleHomeRowItemBinding) : RecyclerView.ViewHolder(item.root) {

        internal fun bind(position: Int) {
            item.model = data[position]
            item.position = position


           /* item.ivDelete.setOnClickListener {
                callback!!.OnRemoveItem(item.ivDelete, position)
            }

            itemView.setOnClickListener{
                callback!!.OnItemClicked(itemView, position)
            }*/


        }

    }

}


