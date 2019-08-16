package com.example.listadapterdraganddropapplication

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

open class MyItemTouchHelperCallback(
    dragDirs: Int = 0,
    private val dragCallback: (Int, Int) -> Unit = { _, _ -> }
) : ItemTouchHelper.SimpleCallback(dragDirs, 0) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val from = viewHolder.adapterPosition
        val to = target.adapterPosition

        dragCallback(from, to)

        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

    override fun isLongPressDragEnabled() = true
}