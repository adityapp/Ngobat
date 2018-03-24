package com.example.axce.ngobat.Activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.widget.RelativeLayout
import com.example.axce.ngobat.Adapter.RvListObatAdapter
import com.example.axce.ngobat.Model.Obat
import com.example.axce.ngobat.Object.ObjectObat
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.activity_find_obat.*

class FindObatActivity : AppCompatActivity() {
    var obat = ObjectObat.objectObat()
    var obatSelect = ArrayList<Obat>()
    lateinit var adapter: RvListObatAdapter

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_obat)

        val actionBar = supportActionBar
        actionBar?.title = "Obat"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        Log.d("CekObat", obat.size.toString())

        find()
        adapter = RvListObatAdapter(this)
        adapter.dataSet = obatSelect
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter
    }

    fun find() {
        for (i in MainActivity.selectGejala) {
            for (j in obat) {
                for (k in 0..j.menangani.size - 1) {
                    if (j.menangani.get(k) == i.namaGejala) {
                        obatSelect.add(j)
                        alert.visibility = RelativeLayout.GONE
                    }
                }
            }
        }
        removeDuplicate()
    }

    fun removeDuplicate() {
        for (i in 0..obatSelect.size - 1) {
            for (j in i + 1..obatSelect.size - 1)
                if (obatSelect.get(i).namaObat == obatSelect.get(j).namaObat) {
                    obatSelect.remove(obatSelect.get(j))
                }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
