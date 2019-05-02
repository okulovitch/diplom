package com.example.ge62.diplomahotelreserv.ui.hotdeals

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.models.Hotel
import kotlinx.android.synthetic.main.hot_deals_item.view.*

class HotHottelsAdapter(val postList: List<Hotel>, val context: Context) :
        RecyclerView.Adapter<HotHottelsAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.hot_deals_item,
                parent, false))
    }

    override fun getItemCount(): Int {
      return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.hotelNameTv.text=postList.get(position).hottelName
        holder.itemView.locationTv.text=postList.get(position).regionName
        // ImageLoader.getInstance().displayImage(hotel.getHotelImage(), holder.hotelImage);

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}