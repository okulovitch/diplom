package com.example.ge62.diplomahotelreserv.ui.addhotel

import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import okhttp3.ResponseBody
import javax.inject.Inject

class AddHotelInfoPresenter :AddHotelInfoContract.Presenter() {


    @Inject
    lateinit var networkManager: NetworkManager
    init {
        BookingApp.getAppComponent().inject(this)
    }

    override fun onAddHotelReqest(phone: String, email: String, description: String, hotelName: String, longitude: String, latitude: String, regionName: String, image: String) {
        networkManager.addHotel(phone,email,description,hotelName,longitude,latitude,regionName,image, object: SmartNetworkCallback<ResponseBody>(getView()) {
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