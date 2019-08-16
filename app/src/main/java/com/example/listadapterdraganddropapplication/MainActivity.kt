package com.example.listadapterdraganddropapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        if ((intent.extras?.getSerializable(KEY_TYPE) as Type == Type.LIST_ADAPTER)) MyListAdapter() else MyListAdapterSync()
    }

    private val itemTouchHelper: ItemTouchHelper = ItemTouchHelper(object : MyItemTouchHelperCallback(
        dragDirs = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END,
        dragCallback = { from, to ->
            adapter.submitList(adapter.items.move(from, to))
        }
    ) {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = adapter.apply {
            submitList(generateSequence(0) { it + 1 }.take(100).toList().map { MyItem(it, Random.nextInt(4) + 1) })
        }

        (recycler_view.layoutManager as GridLayoutManager).spanSizeLookup =
            object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return adapter.items[position].width
                }
            }

        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    companion object {

        private const val KEY_TYPE = "KEY_TYPE"

        fun createIntent(activity: Activity, type: Type) =
            Intent(activity, MainActivity::class.java).putExtra(KEY_TYPE, type)
    }
}