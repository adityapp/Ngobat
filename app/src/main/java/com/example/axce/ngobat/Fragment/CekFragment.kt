package com.example.axce.ngobat.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.axce.ngobat.Activity.*
import com.example.axce.ngobat.Adapter.RvSelectGejalaAdapter
import com.example.axce.ngobat.Model.Gejala

import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.fragment_cek.view.*


/**
 * A simple [Fragment] subclass.
 */
class CekFragment : Fragment() {
    lateinit var selectAdapter: RvSelectGejalaAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_cek, container, false)

        selectAdapter = RvSelectGejalaAdapter(activity)
        view.recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        view.recycler_view.adapter = selectAdapter
        selectAdapter.setOnItemClickListener(object : RvSelectGejalaAdapter.OnItemClickListener {
            override fun onItemClick(p0: Gejala) {
                selectAdapter.notifyDataSetChanged()
            }
        })

        view.btn_kepala.setOnClickListener({
            val intent = Intent(activity, KepalaActivity::class.java)
            activity.startActivity(intent)
        })

        view.btn_badan.setOnClickListener({
            val intent = Intent(activity, BadanActivity::class.java)
            activity.startActivity(intent)
        })

        view.btn_tangan_kanan.setOnClickListener({
            val intent = Intent(activity, TanganActivity::class.java)
            activity.startActivity(intent)
        })

        view.btn_tangan_kiri.setOnClickListener({
            val intent = Intent(activity, TanganActivity::class.java)
            activity.startActivity(intent)
        })

        view.btn_kaki.setOnClickListener({
            val intent = Intent(activity, KakiActivity::class.java)
            activity.startActivity(intent)
        })

        view.btn_generate.setOnClickListener({
            if (MainActivity.selectGejala.size == 0) {
                Toast.makeText(activity, "Silahkan masukkan gejala", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(activity, FindObatActivity::class.java)
                activity.startActivity(intent)
            }
        })

        return view
    }

    override fun onResume() {
        super.onResume()
        selectAdapter.notifyDataSetChanged()
    }
}
