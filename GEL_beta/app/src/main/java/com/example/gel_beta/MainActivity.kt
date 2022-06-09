package com.example.gel_beta

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.gel_beta.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng

class MyApp: Application(){
    lateinit var context: Context
    init {instance=this}
    companion object {
        private var instance: MyApp? = null
        fun applicationContext(): Context{
            return instance!!.applicationContext
        }
    }
}

class MainActivity : AppCompatActivity() {

    private val locationManager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val REQUEST_GPS: Int = 1
    private val PERMISSIONS_GPS = arrayOf<String>(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    companion object{
        private const val PERMISSION_REQUEST_ACCESS_LOCATION = 100
        var userLocation : Location? = null
        var Name : String? = "Youngchan Lim"
        var Nationality : String? = "Republic of Korea"
        var PassPortNo : String? = "XX12345678"
        var EmergencyContactA : String? = "xxxxxxxx@google.com"
        var EmergencyContactB : String? = "+82-10-xxxx-xxxx"
    }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var mLastLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getCurrentLocation();

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_userInformation, R.id.nav_contacts, R.id.nav_about
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun getCurrentLocation() {
        if(checkPermissions()){
            if(isLocationEnabled()){
                if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED)
                {
                    requestPermission()
                    return
                }

                fusedLocationProviderClient.lastLocation.addOnCompleteListener(this){ task ->
                    val location:Location?=task.result
                    if(location==null){
                        Toast.makeText(this,"Null Recieved", Toast.LENGTH_LONG).show()
                        val locationInfo = findViewById<TextView>(R.id.locationInfo)
                        val userName = findViewById<TextView>(R.id.userName_nav)
                        var latitude = "37.3762527"
                        var longitude = "126.667168"
                        var locationText = "Latitude:$latitude \n Longitude:$longitude"
                        locationInfo.setText(locationText)
                        userName.setText(Name)
                    }
                    else{
                        Toast.makeText(this,"Get Success", Toast.LENGTH_LONG).show()
                        userLocation = location
                        val locationInfo = findViewById<TextView>(R.id.locationInfo)
                        val userName = findViewById<TextView>(R.id.userName_nav)

                        var locationText = "Latitude: "+ location.latitude+ "\n"+"Longitude: "+ location.longitude
                        locationInfo.setText(locationText)
                        userName.setText(Name)
                    }
                }

            }
            else{
                Toast.makeText(this,"Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }
        else{
            requestPermission()
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION),
            PERMISSION_REQUEST_ACCESS_LOCATION
        )
    }

    private fun checkPermissions(): Boolean{
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            return true
        }
        return false
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager:LocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSION_REQUEST_ACCESS_LOCATION){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext, "Granted", Toast.LENGTH_SHORT).show()
                getCurrentLocation()
            }
            else{
                Toast.makeText(applicationContext, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val locationInfo = findViewById<TextView>(R.id.locationInfo)
        var locationText = "Latitude: "+ userLocation?.latitude+ "\n"+"Longitude: "+ userLocation?.longitude
        locationInfo.setText(locationText)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}