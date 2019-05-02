package com.example.ge62.diplomahotelreserv.ui.addhotelmain.addroom

import com.example.ge62.diplomahotelreserv.framework.BasePresenter
import com.example.ge62.diplomahotelreserv.framework.MvpView

interface AddHotelRoomContract {

    interface View : MvpView {

        fun openAddHotelListScreen()

    }

    abstract class Presenter : BasePresenter<AddHotelRoomContract.View>() {

        abstract fun onAddRoomReqest(bookId: Int,personsCount: Int, isHot: Boolean,roomNumber: Int,costForNight: Double,costWithSale : Double,checkInDate: String,checkOutDate: String,roomImage: String,roomLocation: String,roomLongitude:Double,roomLatitude: Double)
    }
}