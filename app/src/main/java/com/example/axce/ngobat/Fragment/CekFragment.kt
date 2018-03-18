package com.example.axce.ngobat.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axce.ngobat.Activity.BadanActivity
import com.example.axce.ngobat.Activity.KakiActivity
import com.example.axce.ngobat.Activity.KepalaActivity
import com.example.axce.ngobat.Activity.TanganActivity
import com.example.axce.ngobat.Adapter.RvSelectGejalaAdapter

import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.fragment_cek.view.*


/**
 * A simple [Fragment] subclass.
 */
class CekFragment : Fragment() {
    lateinit var selectAdapter: RvSelectGejalaAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_cek, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)

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
        return view
    }

    override fun onResume() {
        super.onResume()
        selectAdapter = RvSelectGejalaAdapter(activity)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = selectAdapter
    }
}
