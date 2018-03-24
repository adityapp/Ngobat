package com.example.axce.ngobat.Activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.axce.ngobat.Model.Obat
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.activity_detail_obat.*

class DetailObatActivity : AppCompatActivity() {
    lateinit var obat : Obat
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_obat)

        val actionBar = supportActionBar
        actionBar?.title = "Detail Obat"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        obat = intent.getSerializableExtra("obat") as Obat

        nama_obat.setText(obat.namaObat)
        perusahaan.setText(obat.namaPerusahaan)
        harga.setText("Rp. ${obat.harga},-")
        image_obat.setImageDrawable(resources.getDrawable(obat.image,null))

        var listMenangani = ""
        for (i in 0..obat.menangani.size - 1) {
            listMenangani += obat.menangani.get(i)
            if (i == obat.menangani.size - 1) {
                listMenangani += "."
            }else{
                listMenangani += ", "
            }
        }
        menangani.setText(listMenangani)

        var listKomposisi = ""
        for (i in 0..obat.komposisi.size - 1){
            listKomposisi += "- ${obat.komposisi.get(i)}\n"
        }
        komposisi.setText(listKomposisi)

        var listEfekSamping = ""
        for (i in 0..obat.efekSamping.size - 1){
            listEfekSamping += "- ${obat.efekSamping.get(i)}\n"
        }
        efek_samping.setText(listEfekSamping)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
