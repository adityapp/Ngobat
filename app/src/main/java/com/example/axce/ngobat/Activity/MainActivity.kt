package com.example.axce.ngobat.Activity

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.view.MenuItem
import com.example.axce.ngobat.Fragment.ApotekFragment
import com.example.axce.ngobat.Fragment.CekFragment
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_PERMISSION_LOCATION = 9001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, CekFragment()).commit()

        bottom_navigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_cek -> supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, CekFragment()).commit()
                    R.id.action_apotek -> supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, ApotekFragment()).commit()
                }
                return true;
            }

        })

        //permission
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_PERMISSION_LOCATION)
        }
    }
}
