package com.example.gel_beta.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.gel_beta.MainActivity
import com.example.gel_beta.R
import com.example.gel_beta.api.RetrofitClient
import com.example.gel_beta.databinding.ActivityMapsBinding
import com.example.gel_beta.model.google.nearbySearch.NearbySearch
import com.example.gel_beta.model.others.Spot
import com.example.gel_beta.ui.home.maps.MapsController
import com.example.gel_beta.utility.Constants

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mGoogleMap: GoogleMap
    private lateinit var mMapsController: MapsController
    private lateinit var userLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
        mMapsController = MapsController(this, mGoogleMap)
        mMapsController.setCustomMarker()
        userLocation = MainActivity.userLocation!!
        //val suny = LatLng(userLocation.latitude,userLocation.longitude)
        val suny = LatLng(37.3762527,126.667168)
        mGoogleMap.addMarker(MarkerOptions().position(suny).title("My location"))
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(suny, 15F))

        val btn_emergency = findViewById<Button>(R.id.btn_emergency_show)
        btn_emergency.setOnClickListener{
            val position = mGoogleMap.cameraPosition.target.latitude.toString() + "," + mGoogleMap.cameraPosition.target.longitude.toString()
            val placesCall = RetrofitClient.googleMethods().getNearbySearch(position, Constants.RADIUS_1000, Constants.TYPE_BAR_MEDICAL, Constants.GOOGLE_API_KEY)
            placesCall.enqueue(object : Callback<NearbySearch> {
                override fun onResponse(call: Call<NearbySearch>, response: Response<NearbySearch>) {
                    val nearbySearch = response.body()!!
                    mMapsController.clearMarkers()
                    if (nearbySearch.status.equals("OK")) {
                        val spotList = ArrayList<Spot>()
                        for (resultItem in nearbySearch.results!!) {
                            val spot = Spot(resultItem.name, resultItem.geometry.location?.lat, resultItem.geometry.location?.lng)
                            spotList.add(spot)
                        }
                        mMapsController.setMarkersAndZoom(spotList, 0)
                    } else {

                    }
                }
                override fun onFailure(call: Call<NearbySearch>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
        val btn_security = findViewById<Button>(R.id.btn_security_show)
        btn_security.setOnClickListener {
            val position = mGoogleMap.cameraPosition.target.latitude.toString() + "," + mGoogleMap.cameraPosition.target.longitude.toString()
            val placesCall = RetrofitClient.googleMethods().getNearbySearch(position, Constants.RADIUS_1000, Constants.TYPE_BAR_SECURITY, Constants.GOOGLE_API_KEY)
            placesCall.enqueue(object : Callback<NearbySearch> {
                override fun onResponse(call: Call<NearbySearch>, response: Response<NearbySearch>) {
                    val nearbySearch = response.body()!!
                    mMapsController.clearMarkers()
                    if (nearbySearch.status.equals("OK")) {
                        val spotList = ArrayList<Spot>()

                        for (resultItem in nearbySearch.results!!) {
                            val spot = Spot(resultItem.name, resultItem.geometry.location?.lat, resultItem.geometry.location?.lng)
                            spotList.add(spot)
                        }

                        mMapsController.setMarkersAndZoom(spotList, 1)
                    } else {

                    }
                }
                override fun onFailure(call: Call<NearbySearch>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }


    }
}


