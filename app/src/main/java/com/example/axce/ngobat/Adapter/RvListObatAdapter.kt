package com.example.axce.ngobat.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axce.ngobat.Activity.DetailObatActivity
import com.example.axce.ngobat.Model.Obat
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.card_list_obat.view.*
import java.io.ByteArrayInputStream
import java.io.Serializable

/**
 * Created by AXCE on 23/03/2018.
 */
class RvListObatAdapter(val context: Context) : RecyclerView.Adapter<RvListObatAdapter.ViewHolder>() {
    var dataSet = ArrayList<Obat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_obat, parent, false)
        val viewHolder = RvListObatAdapter.ViewHolder(view)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nama_obat.setText(dataSet.get(position).namaObat)
        var menangani = ""
        for (i in 0..dataSet.get(position).menangani.size-1){
            menangani += (dataSet.get(position).menangani.get(i))
            if (i == dataSet.get(position).menangani.size-1){
                menangani += "."
            }else{
                menangani += ", "
            }
        }
        holder.itemView.menangani.setText(menangani)
        holder.itemView.btn_detail.setOnClickListener({
            val intent = Intent(context, DetailObatActivity::class.java)
            intent.putExtra("obat",dataSet.get(position))
            context.startActivity(intent)
        })
        holder.itemView.harga.setText("Rp. ${dataSet.get(position).harga},-")
        holder.itemView.image_obat.setImageDrawable(context.resources.getDrawable(dataSet.get(position).image,null))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

}