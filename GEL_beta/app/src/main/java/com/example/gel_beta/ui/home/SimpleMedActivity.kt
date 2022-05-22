package com.example.gel_beta.ui.home

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
                codeName = "Anti-inflammatory",
                description = "Tylenol(Left)\n Penzal-Q(Middle)\n Geborin-jeong(Right)",
                image = resIdByName("med_a")
            )
        )
        versionList.add(
            Versions(
                codeName = "Cold and cough medicine",
                description = "For runny nose and sneeze: Actifed, Zyrtec\nFor cough: Bascrong, Mucopect",
                image = resIdByName("med_b")
            )
        )
        versionList.add(
            Versions(
                codeName = "Digestive medicine",
                description = "Dages Cap.(Left)\nDr.Bearse(Right)",
                image = resIdByName("med_c")
            )
        )
        versionList.add(
            Versions(
                codeName = "Gastrointestinal medicine",
                description = "Gellfos-L Suspension",
                image = resIdByName("med_d")
            )
        )
        versionList.add(
            Versions(
                codeName = "Anti diarrheal",
                description = "Smecta",
                image = resIdByName("med_e")
            )
        )
    }

    fun resIdByName(name : String): Int {
        return resources.getIdentifier(name, "drawable", packageName)
    }


}