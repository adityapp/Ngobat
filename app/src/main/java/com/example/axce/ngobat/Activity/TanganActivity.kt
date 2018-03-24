package com.example.axce.ngobat.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.example.axce.ngobat.Adapter.RvGejalaAdapter
import com.example.axce.ngobat.Adapter.RvSelectGejalaAdapter
import com.example.axce.ngobat.Model.Gejala
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.activity_tangan.*

class TanganActivity : AppCompatActivity() {
    var gejala = ArrayList<Gejala>()
    lateinit var adapter: RvGejalaAdapter
    lateinit var selectAdapter: RvSelectGejalaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tangan)

        val actionBar = supportActionBar
        actionBar?.title = "Tangan"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        gejala.add(Gejala("Memar"))
        gejala.add(Gejala("Luka"))
        gejala.add(Gejala("Melepuh"))
        gejala.add(Gejala("Gatal-gatal"))

        adapter = RvGejalaAdapter(this)
        adapter.dataSet = gejala
        rv_tangan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_tangan.adapter = adapter

        selectAdapter = RvSelectGejalaAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.adapter = selectAdapter

        adapter.setOnItemClickListener(object : RvGejalaAdapter.OnItemClickListener{
            override fun onItemClick() {
                selectAdapter.notifyDataSetChanged()
            }
        })

        selectAdapter.setOnItemClickListener(object : RvSelectGejalaAdapter.OnItemClickListener{
            override fun onItemClick(p0: Gejala) {
                for (i in gejala){
                    if (i == p0){
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
