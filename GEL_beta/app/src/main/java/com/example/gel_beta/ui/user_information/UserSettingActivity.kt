package com.example.gel_beta.ui.user_information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gel_beta.MainActivity
import com.example.gel_beta.R
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_user_setting.*

class UserSettingActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_setting)

        var save : Button = findViewById<Button>(R.id.save_btn)
        save.setOnClickListener {
            MainActivity.Name = editTextName.text.toString()
            MainActivity.Nationality = editTextNation.text.toString()
            MainActivity.PassPortNo = editTextPassport.text.toString()
            MainActivity.EmergencyContactA = editTextContactA.text.toString()
            MainActivity.EmergencyContactB = editTextContactB.text.toString()
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}