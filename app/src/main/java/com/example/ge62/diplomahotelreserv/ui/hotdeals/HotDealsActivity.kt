package com.example.ge62.diplomahotelreserv.ui.hotdeals

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.adapters.HotDealsListAdapter
import com.example.ge62.diplomahotelreserv.adapters.RVClickListner
import com.example.ge62.diplomahotelreserv.models.Hotel
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import kotlinx.android.synthetic.main.activity_hot_deals.*
import javax.inject.Inject



class HotDealsActivity : BaseActivity() {

    override fun getLayoutRes(): Int = com.example.ge62.diplomahotelreserv.R.layout.activity_hot_deals

    @Inject
    lateinit var networkManager: NetworkManager



    private var listHottels = arrayListOf<Hotel>()
    init {
        BookingApp.getAppComponent().inject(this)
    }

    override fun initViews() {
       initToolbar(toolbar," ",true)




        //     recyclerView?.setAdapter(HotDealsEditListAdapter(this, ,ho, rvClickListner))
        //recyclerView?.setAdapter(HotDealsEditListAdapter(this, HotHotelsCollection.getHottels(), rvClickListner))

    }
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = findViewById(com.example.ge62.diplomahotelreserv.R.id.hotHotellsList) as RecyclerView
        recyclerView?.setLayoutManager(LinearLayoutManager(this))

        networkManager.getAllHottels(object : SmartNetworkCallback<List<Hotel>>() {
            override fun onResult(data: List<Hotel>) {
                super.onResult(data)
                listHottels.clear()
                listHottels.addAll(data)
                initRv()
            //    updateProjectsList()
            }
        })


    }

    private fun initRv() {
        recyclerView?.setAdapter(HotDealsListAdapter(this,listHottels , rvClickListner))
    }

    private val rvClickListner = RVClickListner<Hotel> { item, target ->
        var i = Intent(this@HotDealsActivity, FullItemInfoHotDealsActivity::class.java)
        //i.putExtra("hottel", item)
//        var lat =item.latitude!!.toDouble()
//        var long = item.longitude!!.toDouble()
        i.putExtra("description",item.description)
        i.putExtra("hotelName",item.hottelName)
        i.putExtra("regionName",item.regionName)
      //  i.putExtra("latitude",item.latitude)
     //   i.putExtra("longitude",item.longitude)
        i.putExtra("phone",item.phone)
        i.putExtra("email",item.email)
        i.putExtra("image",item.image)

        val b = Bundle()
        b.putDouble("lat", item.latitude!!)
        b.putDouble("long",item.longitude!!)
        i.putExtras(b)
        startActivity(i)
    }
    override fun release() {
    }

}





