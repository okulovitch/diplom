package com.example.ge62.diplomahotelreserv.ui.hotdeals

import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.models.Hotel
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import javax.inject.Inject

class HotDealsPresenter : HotDealsContract.Presenter() {

    @Inject
    lateinit var networkManager: NetworkManager



    private var listHottels = arrayListOf<Hotel>()
    init {
        BookingApp.getAppComponent().inject(this)
    }

    override fun onAttachView(view: HotDealsContract.View) {
        super.onAttachView(view)
        loadHottels()
    }


    override fun onGetHottelsReqest() {


    }

    private fun loadHottels(){
        networkManager.getAllHottels(object : SmartNetworkCallback<List<Hotel>>(getView()) {
            override fun onResult(data: List<Hotel>) {
                super.onResult(data)
                listHottels.clear()
                listHottels.addAll(data)

                updateProjectsList()
            }
        })
    }

    private fun updateProjectsList(){
        getView()?.showListOfHottels(listHottels)
    }
}