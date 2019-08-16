package com.example.listadapterdraganddropapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class ListAdapterWithItems : ListAdapter<MyItem, ListAdapterWithItems.ViewHolder> {

    constructor(diffcallback: DiffUtil.ItemCallback<MyItem>) : super(diffcallback) {
        this.items = emptyList()
    }

    constructor(config: AsyncDifferConfig<MyItem>) : super(config) {
        this.items = emptyList()
    }

    var items: List<MyItem>
        private set

    override fun submitList(list: List<MyItem>?) {
        super.submitList(list)
        this.items = list ?: emptyList()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.text_view)

        fun bind(myItem: MyItem) {
            textView.text = myItem.number.toString()
        }
    }
}