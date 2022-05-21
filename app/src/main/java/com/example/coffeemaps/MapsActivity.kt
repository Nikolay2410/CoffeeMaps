package com.example.coffeemaps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeemaps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_CoffeeMaps)
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    //55.759758, 37.765755
    //55.765917, 37.702659
    //55.753294, 37.702052
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val coffee1 = LatLng(55.759758, 37.765755)
        val coffee2 = LatLng(55.765917, 37.702659)
        val coffee3 = LatLng(55.753294, 37.702052)

        mMap.addMarker(MarkerOptions().position(coffee1).title("Coffee 1"))
        mMap.addMarker(MarkerOptions().position(coffee2).title("Coffee 2"))
        mMap.addMarker(MarkerOptions().position(coffee3).title("Coffee 3"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coffee2,11f))
        val intent = Intent(this, MenuActivity::class.java)
        mMap.setOnMarkerClickListener (object : GoogleMap.OnMapClickListener,
            GoogleMap.OnMarkerClickListener {
            override fun onMarkerClick(m: Marker): Boolean {
                Log.i("Coffee", "Location is ${m.title}")

                when (m.title) {
                    "Coffee 1" -> {
                        intent.putExtra("title", "Кофейня №1")
                    }
                    "Coffee 2" -> {
                        intent.putExtra("title", "Кофейня №2")
                    }
                    "Coffee 3" -> {
                        intent.putExtra("title", "Кофейня №3")
                    }
                }
                startActivity(intent)
                //Toast.makeText(this@MapsActivity, "Location is ${m.title}", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onMapClick(p0: LatLng) {
                TODO("Not yet implemented")
            }

        })
    }
}