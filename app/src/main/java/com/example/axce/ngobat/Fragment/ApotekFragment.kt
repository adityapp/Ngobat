package com.example.axce.ngobat.Fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.axce.ngobat.Model.Apotek

import com.example.axce.ngobat.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_apotek.*


/**
 * A simple [Fragment] subclass.
 */
class ApotekFragment : Fragment(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private lateinit var mapFragment: MapFragment
    private lateinit var gMap: GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var googleApiClient: GoogleApiClient? = null
    private val db = FirebaseFirestore.getInstance()
    private var listApotek = ArrayList<Apotek.Result>()
    private var selectMarker: GeoPoint? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_apotek, container, false)

        //Map
        mapFragment = MapFragment.newInstance()
        mapFragment.getMapAsync(this)

        var fragmentTransaction = activity.fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.map, mapFragment)
        fragmentTransaction.commit()

        if (googleApiClient == null) {
            googleApiClient = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build()
        }
        return view
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        gMap = googleMap!!
        gMap.uiSettings.isMapToolbarEnabled = false
        getMarker()
        gMap.setOnMarkerClickListener(object : GoogleMap.OnMarkerClickListener {
            override fun onMarkerClick(marker: Marker?): Boolean {
                if (marker != null) {
                    for (i in 0..listApotek.size - 1) {
                        if (listApotek.get(i).nama.equals(marker.title)) {
                            selectMarker = listApotek.get(i).location
                        }
                    }
                }
                return false
            }
        })
        updateLocation()
    }

    private fun updateLocation() {
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(activity, OnSuccessListener<Location> { location ->
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    LatLng(location.latitude, location.longitude), 15f)
                            )
                            gMap.animateCamera(CameraUpdateFactory.zoomTo(15f), 2000, null)
                            direct.setOnClickListener {
                                if (selectMarker == null) {
                                    Toast.makeText(activity, "Tujuan tidak ada", Toast.LENGTH_SHORT).show()
                                } else {
                                    val gmmIntentUri = Uri.parse("google.navigation:q=" + selectMarker?.getLatitude() + "," + selectMarker?.getLongitude())
                                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                                    startActivity(mapIntent)
                                }
                            }
                        }
                    })
            gMap.isMyLocationEnabled = true
        }
    }

    fun getMarker() {
        db.collection("Apotek").addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(snapshot: QuerySnapshot?, e: FirebaseFirestoreException?) {
                if (snapshot != null) {
                    for (document in snapshot.documentChanges) {
                        val apotek = document.document.toObject(Apotek.Result::class.java)
                        gMap.addMarker(MarkerOptions().position(LatLng(apotek.location.latitude, apotek.location.longitude))
                                .title(apotek.nama).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker)))
                        listApotek.add(apotek)
                    }
                }
            }
        })
    }

    override fun onConnected(p0: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
