package com.example.gel_beta.ui.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.gel_beta.R

class SimpleMedActivity : AppCompatActivity() {

    val versionList = ArrayList<Versions>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_med)
        initData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val versionAdapter = VersionAdapter(versionList)
        val recyclerView = findViewById<RecyclerView> (R.id.recyclerView)
        recyclerView.adapter = versionAdapter
        recyclerView.setHasFixedSize(true)
    }

    private fun initData() {

        versionList.add(
            Versions(
                codeName = "Android 10",
                version = "Version 10",
                apiLevel = "Api Level 29",
                description = "testing A"
            )
        )

        versionList.add(
            Versions(
                codeName = "Android 9",
                version = "Version 9",
                apiLevel = "Api Level 24",
                description = "testing B"
            )
        )



    }

}