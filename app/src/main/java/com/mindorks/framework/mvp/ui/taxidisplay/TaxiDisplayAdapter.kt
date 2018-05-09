package com.mindorks.framework.mvp.ui.taxidisplay

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.taxidisplay.model.PoiList

/**
 * Created by Akki on 5/7/2018.
 */
class TaxiDisplayAdapter (val carList : List<PoiList>?,listener:OnTaxiSelect):RecyclerView.Adapter<TaxiDisplayAdapter.MyViewHolder>() {
    var mlistener=listener
    override fun getItemCount(): Int {
       return carList!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.listrow_taxi_details, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.line.text=carList?.get(position)?.fleetType
        holder.direction.text=carList?.get(position)?.distance + " km"

        holder.itemView.setOnClickListener { mlistener.onCallback(position)}
    }

 class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var time: TextView
        var direction: TextView
        var line: TextView

        init {
            time = itemView.findViewById(R.id.timeStamp)
            direction = itemView.findViewById(R.id.direction)
            line = itemView.findViewById(R.id.line_num)
        }
    }
}