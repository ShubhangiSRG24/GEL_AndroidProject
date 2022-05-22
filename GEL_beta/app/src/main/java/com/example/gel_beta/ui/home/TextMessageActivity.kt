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
import com.example.gel_beta.R
import com.google.android.gms.maps.model.LatLng
import java.util.*

class TextMessageActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                var userLocation: Location = getLatLng()
                var mylocation = LatLng(userLocation.latitude, userLocation.longitude)
                var textMessage = "위치: 경도 "+userLocation.latitude.toString()+"\n"+"위도 "+userLocation.longitude.toString() + "\n지금 이상한 사람이 따라오고 있어요, 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
            R.id.btn_lost -> {
                var userLocation: Location = getLatLng()
                var mylocation = LatLng(userLocation.latitude, userLocation.longitude)
                var textMessage = "위치: 경도 "+userLocation.latitude.toString()+"\n"+"위도 "+userLocation.longitude.toString() + "\n여기가 어딘지 모르겠습니다. 주변에 아무도 없습니다. 곧 핸드폰이 꺼집니다. 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
            R.id.btn_blackmail -> {
                var userLocation: Location = getLatLng()
                var mylocation = LatLng(userLocation.latitude, userLocation.longitude)
                var textMessage = "위치: 경도 "+userLocation.latitude.toString()+"\n"+"위도 "+userLocation.longitude.toString() + "\n협박당하고 있습니다 부디 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
            R.id.btn_lockedup -> {
                var userLocation: Location = getLatLng()
                var mylocation = LatLng(userLocation.latitude, userLocation.longitude)
                var textMessage = "위치: 경도 "+userLocation.latitude.toString()+"\n"+"위도 "+userLocation.longitude.toString() + "\n어딘지 모르게 갇혀있고 누군가가 감시하고 있습니다. 도와주세요"
                val num = "smsto:01080085899"
                var nextIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(num))
                nextIntent.putExtra("sms_body", textMessage)
                startActivity(nextIntent)
            }
        }
    }
    private fun getLatLng(): Location {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var currentLatLng: Location? = null
        var hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)
        var hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION)
        if(hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
            hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED){
            val locationProvider = LocationManager.GPS_PROVIDER
            currentLatLng = locationManager?.getLastKnownLocation(locationProvider)
        }
        return currentLatLng!!
    }
}