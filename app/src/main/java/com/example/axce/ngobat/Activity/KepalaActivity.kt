package com.example.axce.ngobat.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.axce.ngobat.Adapter.RvGejalaAdapter
import com.example.axce.ngobat.Model.Obat
import com.example.axce.ngobat.R

class KepalaActivity : AppCompatActivity() {
    var dataSet = ArrayList<Obat>()
    lateinit var adapter: RvGejalaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kepala)

    }
}
