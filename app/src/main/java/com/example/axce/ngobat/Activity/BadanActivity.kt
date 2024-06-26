package com.example.axce.ngobat.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.example.axce.ngobat.Adapter.RvGejalaAdapter
import com.example.axce.ngobat.Adapter.RvSelectGejalaAdapter
import com.example.axce.ngobat.Model.Gejala
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.activity_badan.*

class BadanActivity : AppCompatActivity() {
    var gejala = ArrayList<Gejala>()
    lateinit var adapter: RvGejalaAdapter
    lateinit var selectAdapter: RvSelectGejalaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badan)

        val actionBar = supportActionBar
        actionBar?.title = "Badan"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        gejala.add(Gejala("Perut kembung"))
        gejala.add(Gejala("Menggigil"))
        gejala.add(Gejala("Mual"))
        gejala.add(Gejala("Tidak nafsu makan"))
        gejala.add(Gejala("Diare"))

        adapter = RvGejalaAdapter(this)
        adapter.dataSet = gejala
        rv_badan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_badan.adapter = adapter

        selectAdapter = RvSelectGejalaAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.adapter = selectAdapter

        adapter.setOnItemClickListener(object : RvGejalaAdapter.OnItemClickListener {
            override fun onItemClick() {
                selectAdapter.notifyDataSetChanged()
            }
        })

        selectAdapter.setOnItemClickListener(object : RvSelectGejalaAdapter.OnItemClickListener {
            override fun onItemClick(p0: Gejala) {
                for (i in gejala) {
                    if (i == p0) {
                        i.select = false
                        adapter.notifyDataSetChanged()
                    }
                }
                selectAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
