package com.example.gel_beta.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import com.example.gel_beta.MainActivity
import com.example.gel_beta.R

class EmergencyCallActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_call)

        val call_end_btn: Button = findViewById(R.id.call_end_emergency)
        call_end_btn.setOnClickListener{
            var nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
            finishActivity(0)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}