package com.example.ge62.diplomahotelreserv.ui.signin

import com.example.ge62.diplomahotelreserv.BookingApp
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.SmartNetworkCallback
import com.example.ge62.diplomahotelreserv.rest.responses.AuthResponse
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import com.example.ge62.diplomahotelreserv.storage.UserStorage
import javax.inject.Inject

class SignInPresenter : SignInContract.Presenter() {

    @Inject
    lateinit var networkManager: NetworkManager
    @Inject
    lateinit var userStorage: UserStorage




    init {
    BookingApp.getAppComponent().inject(this)
}
    override fun onLoginRequest(username: String, password: String) {


        networkManager.login(username, password, object: SmartNetworkCallback<AuthResponse>(getView()) {
            override fun onRequestStart() {

            }

            override fun onResult(data: AuthResponse) {
                super.onResult(data)
                userStorage?.setToken(data.token!!)
             //   userStorage!!.saveToken(data.token!!)
                //    requestBuilder.header(RestFactory.X_TOKEN,token)
                getView()?.openMainScreen()
            }
            override fun onFailure(message: String) {
                super.onFailure(message)
                getView()?.badLoginPssword()

            }
            override fun onUnsuccessfulResult(response: ErrorResponse) {
                super.onUnsuccessfulResult(response)
//                getView()?.showMessage(response.code!!)
//                getView()?.showErrorState()
            }
        })

    }

    override fun onSignUpClick() {
        getView()?.openSignUpScreen()
    }
}