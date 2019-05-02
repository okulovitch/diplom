//package com.example.ge62.diplomahotelreserv.adapters
//
//import android.support.v7.widget.RecyclerView
//import android.view.View
//import android.widget.TextView
//import com.example.ge62.diplomahotelreserv.R
////import com.example.ge62.diplomahotelreserv.models.HotDealHotels
//import com.example.ge62.diplomahotelreserv.models.Hotel
//import java.lang.ref.WeakReference
//
//class HottelsAdapter (listner: RVClickListner<Hotel>):BaseRecyclerViewAdapter<Hotel,HottelsAdapter.CardHolder>() {
//
//    class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val cell = itemView.findViewById<View>(R.id.hot_details_item)
//        var nameView = itemView.findViewById<TextView>(R.id.hottelNameTv)
//        var adres = itemView.findViewById<TextView>(R.id.locationTv)
//        var cost = itemView.findViewById<TextView>(R.id.costTv)
//        var iconView = itemView.findViewById<TextView>(R.id.hotelImage)
//
//        fun onBind(data: Hotel) {
//            nameView.setText(data.hottelName)
//            adres.setText(data.regionName)
//            cost.setText(data.longitude)
//            iconView.setText(data.image)
//
//
//        }
//
//    }
//
//    private val callbackRef = WeakReference<RVClickListner<Hotel>>(listner)
//
//    override fun prepareViewHolder(view: View, viewType: Int) = CardHolder(view)
//
//    override fun resourcesId(viewType: Int) = R.layout.hot_deals_item
//
//
//    override fun onBindViewHolder(holder: CardHolder, position: Int) {
//        val hottel = list[holder.adapterPosition]
//        holder.onBind(hottel)
//
//        holder.cell.tag = hottel
//        holder.cell.setOnClickListener {
//            callbackRef.get()?.onItemClick(it.tag as Hotel,1)
//        }
//
//
//    }
//}