package com.example.gel_beta.ui.home

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.core.content.ContextCompat
import com.example.gel_beta.MainActivity
import com.example.gel_beta.R
import com.google.android.gms.maps.model.LatLng
import java.util.*

class TextMessageActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var userLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userLocation = MainActivity.userLocation!!

        setContentView(R.layout.activity_text_message)

        val stalker: Button = findViewById(R.id.btn_stalker)
        stalker.setOnClickListener(this)

        val lost: Button = findViewById(R.id.btn_lost)
        lost.setOnClickListener(this)

        val blackmailed: Button = findViewById(R.id.btn_blackmail)
        blackmailed.setOnClickListener(this)

        val lockedup: Button = findViewById(R.id.btn_lockedup)
        lockedup.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_stalker -> {
                userLocation = MainActivity.userLocation!!
                var textMessage = "위치(경도 "+userLocation.latitude.toString()+"\n"+"/위도 "+userLocation.longitude.toString()+")" + "\n지금 이상한 사람이 따라오고 있어요, 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
            R.id.btn_lost -> {
                userLocation = MainActivity.userLocation!!
                var textMessage = "위치(경도 "+userLocation.latitude.toString()+"\n"+"/위도 "+userLocation.longitude.toString()+")" + "\n지금 이상한 사람이 따라오고 있어요, 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
            R.id.btn_blackmail -> {
                userLocation = MainActivity.userLocation!!
                var textMessage = "위치(경도 "+userLocation.latitude.toString()+"\n"+"/위도 "+userLocation.longitude.toString()+")" + "\n지금 이상한 사람이 따라오고 있어요, 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
            R.id.btn_lockedup -> {
                userLocation = MainActivity.userLocation!!
                var textMessage = "위치(경도 "+userLocation.latitude.toString()+"\n"+"/위도 "+userLocation.longitude.toString()+")" + "\n지금 이상한 사람이 따라오고 있어요, 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
        }
    }
}