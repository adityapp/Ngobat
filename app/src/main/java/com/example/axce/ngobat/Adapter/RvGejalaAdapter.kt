package com.example.axce.ngobat.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axce.ngobat.Activity.MainActivity
import com.example.axce.ngobat.Model.Gejala
import com.example.axce.ngobat.R
import kotlinx.android.synthetic.main.card_list_gejala.view.*

/**
 * Created by AXCE on 17/03/2018.
 */
class RvGejalaAdapter(val context: Context) : RecyclerView.Adapter<RvGejalaAdapter.ViewHolder>() {
    var dataSet = ArrayList<Gejala>()
    private lateinit var onItemClickListener: RvGejalaAdapter.OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvGejalaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_gejala, parent, false)
        val viewHolder = RvGejalaAdapter.ViewHolder(view)

        if (MainActivity.selectGejala != null){
            for (i in MainActivity.selectGejala){
                for (j in 0..dataSet.size-1){
                    if (dataSet.get(j).namaGejala.equals(i.namaGejala)){
                        dataSet.get(j).select = true
                    }
                }
            }
        }
        return viewHolder
    }

    fun setOnItemClickListener(onItemClickListener: RvGejalaAdapter.OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RvGejalaAdapter.ViewHolder, position: Int) {
        holder.itemView.image_done.visibility = View.GONE
        if (dataSet.get(position).select){
            holder.itemView.image_done.visibility = View.VISIBLE
        }
        holder.itemView.nama_gejala.setText(dataSet.get(position).namaGejala)
        holder.itemView.card_view_list_gejala.setOnClickListener({
            if (dataSet.get(position).select) {
                holder.itemView.image_done.visibility = View.GONE
                dataSet.get(position).select = false
                delete(dataSet.get(position).namaGejala)
                Log.d("sgSize", MainActivity.selectGejala.size.toString())
            } else {
                holder.itemView.image_done.visibility = View.VISIBLE
                dataSet.get(position).select = true
                MainActivity.selectGejala.add(dataSet.get(position))
                Log.d("sgSize", MainActivity.selectGejala.size.toString())
            }
            onItemClickListener.onItemClick()
        })
    }

    fun delete(nama: String) {
        for (i in MainActivity.selectGejala) {
            if (i.namaGejala.equals(nama)) {
                MainActivity.selectGejala.remove(i)
                break
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    interface OnItemClickListener {
        fun onItemClick()
    }
}