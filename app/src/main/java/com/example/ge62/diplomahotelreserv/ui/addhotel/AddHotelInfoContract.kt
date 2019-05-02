package com.example.ge62.diplomahotelreserv.ui.addhotel

import com.example.ge62.diplomahotelreserv.framework.BasePresenter
import com.example.ge62.diplomahotelreserv.framework.MvpView

interface AddHotelInfoContract {

    interface View : MvpView {

        fun openAddHotelListScreen()

    }

    abstract class Presenter : BasePresenter<AddHotelInfoContract.View>() {

        abstract fun onAddHotelReqest(phone: String, email: String,description: String,hotelName: String,longitude: String, latitude: String,regionName: String,image: String)
    }
}