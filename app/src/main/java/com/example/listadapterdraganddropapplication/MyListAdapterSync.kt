package com.example.listadapterdraganddropapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import java.util.concurrent.Executor

class MyListAdapterSync : ListAdapterWithItems(createSyncConfig(DiffItemCallback())) {

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

private val syncThreadExecutor = SyncThreadExecutor()

@SuppressLint("RestrictedApi")
fun <T> createSyncConfig(diffCallback: DiffUtil.ItemCallback<T>) =
    AsyncDifferConfig.Builder<T>(diffCallback)
        .setBackgroundThreadExecutor(syncThreadExecutor)
        .setMainThreadExecutor(syncThreadExecutor)
        .build()

class SyncThreadExecutor : Executor {
    override fun execute(command: Runnable) {
        command.run()
    }
}