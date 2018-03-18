package com.example.axce.ngobat.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axce.ngobat.Activity.MainActivity
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.card_list_select_gejala.view.*

/**
 * Created by AXCE on 17/03/2018.
 */
class RvSelectGejalaAdapter(val context: Context): RecyclerView.Adapter<RvSelectGejalaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvSelectGejalaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_select_gejala, parent, false)
        val viewHolder = RvSelectGejalaAdapter.ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        Log.d("dariAdapter",MainActivity.selectGejala.size.toString())
        return MainActivity.selectGejala.size
    }

    override fun onBindViewHolder(holder: RvSelectGejalaAdapter.ViewHolder, position: Int) {
        holder.itemView.select_gejala_nama.setText(MainActivity.selectGejala.get(position).namaGejala)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}