package com.example.axce.ngobat.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axce.ngobat.Model.Gejala
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.card_list_gejala.view.*

/**
 * Created by AXCE on 17/03/2018.
 */
class RvGejalaAdapter(val context: Context): RecyclerView.Adapter<RvGejalaAdapter.ViewHolder>() {
    var dataSet = ArrayList<Gejala>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvGejalaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_gejala,parent,false)
        val viewHolder = RvGejalaAdapter.ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RvGejalaAdapter.ViewHolder, position: Int) {
        holder.itemView.nama_gejala.setText("Nama Gejala")
        if (dataSet.get(position).select){
            holder.itemView.image_done.visibility = View.GONE
        }else{
            holder.itemView.image_done.visibility = View.INVISIBLE
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}