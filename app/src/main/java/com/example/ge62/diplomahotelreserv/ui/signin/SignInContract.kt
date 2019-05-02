package com.example.ge62.diplomahotelreserv.ui.signin

import com.example.ge62.diplomahotelreserv.framework.BasePresenter
import com.example.ge62.diplomahotelreserv.framework.MvpView

interface SignInContract {

    interface View :MvpView  {

        fun openSignUpScreen()
        fun openMainScreen()
        fun badLoginPssword()

    }

    abstract class Presenter : BasePresenter<SignInContract.View>() {

        abstract fun onLoginRequest(username: String, password: String)
        abstract fun onSignUpClick()
    }
}