package com.example.ge62.diplomahotelreserv.ui.signup

import com.example.ge62.diplomahotelreserv.framework.BasePresenter
import com.example.ge62.diplomahotelreserv.framework.MvpView

interface SignUpContract {

    interface View : MvpView {

        fun openSignInScreen()

    }

    abstract class Presenter : BasePresenter<SignUpContract.View>() {

        abstract fun onRegisterRequest(username: String, password: String,firstName: String,email: String)
    }
}