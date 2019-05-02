package com.example.ge62.diplomahotelreserv.ui.addhotelmain.addroom

import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import okhttp3.ResponseBody
import javax.inject.Inject

class AddHotelRoomPresenter :AddHotelRoomContract.Presenter() {


    @Inject
    lateinit var networkManager: NetworkManager
    init {
        BookingApp.getAppComponent().inject(this)
    }
    override fun onAddRoomReqest(bookId: Int, personsCount: Int, isHot: Boolean, roomNumber: Int, costForNight: Double, costWithSale: Double, checkInDate: String, checkOutDate: String, roomImage: String, roomLocation: String, roomLongitude: Double, roomLatitude: Double) {
        networkManager.addRoomByHotelId(bookId,roomNumber,costForNight,costWithSale,checkInDate,checkOutDate,roomImage,roomLocation,personsCount,roomLongitude,roomLatitude,isHot,object: SmartNetworkCallback<ResponseBody>(getView()){
            override fun onRequestStart() {

            }

            override fun onResult(data: ResponseBody) {
                super.onResult(data)
                getView()?.openAddHotelListScreen()
            }
            override fun onFailure(message: String) {
                super.onFailure(message)

            }
            override fun onUnsuccessfulResult(response: ErrorResponse) {
                super.onUnsuccessfulResult(response)
//                getView()?.showMessage(response.code!!)
//                getView()?.showErrorState()
            }
        })
    }


}