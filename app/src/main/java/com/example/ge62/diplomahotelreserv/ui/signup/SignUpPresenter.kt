package com.example.ge62.diplomahotelreserv.ui.signup

import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import okhttp3.ResponseBody
import javax.inject.Inject

class SignUpPresenter : SignUpContract.Presenter() {

    @Inject
    lateinit var networkManager: NetworkManager
    init {
        BookingApp.getAppComponent().inject(this)
    }
    override fun onRegisterRequest(username: String, password: String, firstName: String, email: String) {


        networkManager.register(username,password,firstName,email, object: SmartNetworkCallback<ResponseBody>(getView()) {
            override fun onRequestStart() {

            }

            override fun onResult(data: ResponseBody) {
                super.onResult(data)
                getView()?.openSignInScreen()
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