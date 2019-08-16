package com.example.listadapterdraganddropapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_initial.*
import kotlinx.android.synthetic.main.content_initial.*

class InitialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
        setSupportActionBar(toolbar)

        listadapter_button.setOnClickListener {
            startActivity(MainActivity.createIntent(this, Type.LIST_ADAPTER))
        }

        listadapter_sync_button.setOnClickListener {
            startActivity(MainActivity.createIntent(this, Type.LIST_ADAPTER_SYNC))
        }
    }
}
