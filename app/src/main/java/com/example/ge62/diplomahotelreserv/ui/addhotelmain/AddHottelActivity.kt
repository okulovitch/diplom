package com.example.ge62.diplomahotelreserv.ui.addhotelmain

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.adapters.HotDealsEditListAdapter
import com.example.ge62.diplomahotelreserv.adapters.RVClickListner
import com.example.ge62.diplomahotelreserv.adapters.RecyclerItemTouchHelper
import com.example.ge62.diplomahotelreserv.models.Hotel
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import com.example.ge62.diplomahotelreserv.ui.addhotel.AddHottelInfoActivity
import com.example.ge62.diplomahotelreserv.ui.addhotelmain.addroom.AddHotelRoomActivity
import kotlinx.android.synthetic.main.activity_add_hottel.*
import okhttp3.ResponseBody
import javax.inject.Inject








class AddHottelActivity : BaseActivity(),RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, View.OnClickListener {


    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int, position: Int) {

        if (viewHolder is HotDealsEditListAdapter.MyHolder) {

            mAdapter?.getId(viewHolder.adapterPosition)?.let {
                networkManager.deleteHotel(it, object : SmartNetworkCallback<ResponseBody>() {
                    override fun onResult(data: ResponseBody) {
                        super.onResult(data)
                                // listHottels.clear()
                        recyclerView?.setAdapter(mAdapter)
                        //   initRv()
                    }
                })
                mAdapter?.removeItem(viewHolder.adapterPosition)
            }

        }

    }

    override fun getLayoutRes() = com.example.ge62.diplomahotelreserv.R.layout.activity_add_hottel
   // private var presenter: ProjectDetailsContract.Presenter? = null
   @Inject
   lateinit var networkManager: NetworkManager
    private var recyclerView: RecyclerView? = null
    private var mAdapter: HotDealsEditListAdapter? = null
    private var listHottels = arrayListOf<Hotel>()
    init {
        BookingApp.getAppComponent().inject(this)
    }

    override fun initViews() {
        initToolbar(findViewById(com.example.ge62.diplomahotelreserv.R.id.toolbar), "On main", true)
       addHottel.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // mAdapter = HotDealsEditListAdapter(this, listHottels,rvClickListner)
        var addBtn =findViewById(R.id.addHottel) as Button
        var deniedTv = findViewById(R.id.noPermissionTv) as TextView
        recyclerView = findViewById(com.example.ge62.diplomahotelreserv.R.id.editHotellsList) as RecyclerView
        recyclerView?.setLayoutManager(LinearLayoutManager(this))
        val itemTouchHelperCallback = RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
        mAdapter = HotDealsEditListAdapter(this, listHottels,rvClickListner)
        networkManager.getAllHottels(object : SmartNetworkCallback<List<Hotel>>() {
            override fun onResult(data: List<Hotel>) {
                super.onResult(data)
                listHottels.clear()
                listHottels.addAll(data)
                recyclerView?.setAdapter(mAdapter)
            //   initRv()
            }
            override fun onFailure(message: String) {
                super.onFailure(message)
                deniedTv.visibility = View.VISIBLE
                addBtn.visibility = View.GONE
            }
            override fun onUnsuccessfulResult(response: ErrorResponse) {
                super.onUnsuccessfulResult(response)
                deniedTv.visibility = View.VISIBLE
                addBtn.visibility = View.GONE
//                getView()?.showMessage(response.code!!)
//                getView()?.showErrorState()
            }
        })


    }
    private fun initRv() {
        recyclerView?.setAdapter(HotDealsEditListAdapter(this,listHottels , rvClickListner))
    }

    private val rvClickListner = RVClickListner<Hotel> { item, target ->
        var i = Intent(this@AddHottelActivity, AddHotelRoomActivity::class.java)

        i.putExtra("hotel", item.hottelId)
        i.putExtra("location",item.regionName)
        i.putExtra("longitude",item.longitude)
        i.putExtra("latitude",item.latitude)
        startActivity(i)
    }



    override fun release() {
//        presenter?.onDetachView()
//        presenter?.release()
 //       presenter = null

    }


    override fun onClick(view: View?) {
        when(view?.id){
            com.example.ge62.diplomahotelreserv.R.id.addHottel ->{
                val intent = Intent(this, AddHottelInfoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}