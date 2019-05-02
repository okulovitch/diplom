package com.example.ge62.diplomahotelreserv.ui.hotrooms

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu

import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.R.id
import com.example.ge62.diplomahotelreserv.R.layout
import com.example.ge62.diplomahotelreserv.adapters.HotRoomsListAdapter
import com.example.ge62.diplomahotelreserv.adapters.RVRoomClickListner
import com.example.ge62.diplomahotelreserv.models.Room
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import kotlinx.android.synthetic.main.activity_hot_rooms.*
import javax.inject.Inject







class HotRoomsActivity:BaseActivity() {
    override fun getLayoutRes()= layout.activity_hot_rooms

    @Inject
    lateinit var networkManager: NetworkManager
    private var mAdapter : HotRoomsListAdapter? = null
    private var searchView: SearchView? = null
    private var listHotRooms = arrayListOf<Room>()
    init {
        BookingApp.getAppComponent().inject(this)
    }
    override fun initViews() {
        initToolbar(toolbar," on Main",true)
        setSupportActionBar(toolbar)
        mAdapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.searchview,menu)
        mAdapter?.notifyDataSetChanged()
        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu?.findItem(id.action_search)?.actionView as SearchView
        searchView!!.setSearchableInfo(searchManager
                .getSearchableInfo(componentName))
        searchView!!.maxWidth = Integer.MAX_VALUE

        // listening to search query text change
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // filter recycler view when query submitted
                mAdapter!!.getFilter().filter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                // filter recycler view when text is changed
                mAdapter!!.getFilter().filter(query)
                return false
            }
        })
        return true
    }

    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = findViewById(com.example.ge62.diplomahotelreserv.R.id.hotRoomslist) as RecyclerView
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.setLayoutManager(mLayoutManager)
        recyclerView?.setItemAnimator(DefaultItemAnimator())

        mAdapter?.notifyDataSetChanged()

        networkManager.getAllHotRooms(object : SmartNetworkCallback<List<Room>>() {
            override fun onResult(data: List<Room>) {
                super.onResult(data)
                listHotRooms.clear()
                listHotRooms.addAll(data)
                mAdapter?.notifyDataSetChanged()
                mAdapter = HotRoomsListAdapter(this@HotRoomsActivity, listHotRooms, rvClickListner)
                recyclerView?.setAdapter(mAdapter)
                //initRv()
                //    updateProjectsList()
            }
        })



    }



    private fun initRv() {
        recyclerView?.setAdapter(HotRoomsListAdapter(this,listHotRooms,rvClickListner))
    }

    private val rvClickListner = RVRoomClickListner<Room> { item, target ->
        val i = Intent(this@HotRoomsActivity, HotRoomFulInfoActivity::class.java)
//        var lat =item.latitude!!.toDouble()
//        var long = item.longitude!!.toDouble()
        i.putExtra("persons",item.personsCount.toString())
        i.putExtra("roomNumber",item.roomNumber.toString())
        i.putExtra("regionName",item.roomLocation)
        i.putExtra("costWithSale",item.costWithSale.toString())
        i.putExtra("costForNight",item.costForNight.toString())
        i.putExtra("image",item.roomImage)
        val b = Bundle()
        b.putDouble("lat", item.roomLatitude!!)
        b.putDouble("long",item.roomLongitude!!)
        i.putExtras(b)
        startActivity(i)
    }
    override fun release() {
        mAdapter?.notifyDataSetChanged()
    }
}