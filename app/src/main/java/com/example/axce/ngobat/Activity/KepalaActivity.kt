package com.example.axce.ngobat.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.axce.ngobat.Adapter.RvGejalaAdapter
import com.example.axce.ngobat.Model.Gejala
import com.example.axce.ngobat.R

class KepalaActivity : AppCompatActivity() {
    var gejala = ArrayList<Gejala>()
    lateinit var adapter: RvGejalaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kepala)

        gejala.add(Gejala("Pusing"))
        gejala.add(Gejala("Hidung tersumbat"))
        gejala.add(Gejala("Pilek"))
        gejala.add(Gejala("Bibir pecah-pecah"))
        gejala.add(Gejala("Panas"))
        gejala.add(Gejala("Mata merah"))
    }
}
