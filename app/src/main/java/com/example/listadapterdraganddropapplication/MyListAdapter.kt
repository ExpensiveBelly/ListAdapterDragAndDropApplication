package com.example.listadapterdraganddropapplication

import android.view.LayoutInflater
import android.view.ViewGroup

class MyListAdapter : ListAdapterWithItems(DiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.row_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}