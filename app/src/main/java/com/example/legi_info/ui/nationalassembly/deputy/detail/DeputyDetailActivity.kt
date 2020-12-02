package com.example.legi_info.ui.nationalassembly.deputy.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.legi_info.R

class DeputyDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.nav_host_activity)
        findNavController(R.id.nav_host_fragment).setGraph(R.navigation.deputy_detail, intent.extras)
    }
}