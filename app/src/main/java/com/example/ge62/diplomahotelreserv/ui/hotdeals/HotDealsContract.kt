package com.example.ge62.diplomahotelreserv.ui.hotdeals

import com.example.ge62.diplomahotelreserv.framework.BasePresenter
import com.example.ge62.diplomahotelreserv.framework.MvpView
import com.example.ge62.diplomahotelreserv.models.Hotel

interface HotDealsContract {

    interface View : MvpView {

        fun showListOfHottels(listHottels: ArrayList<Hotel>);

    }

    abstract class Presenter : BasePresenter<HotDealsContract.View>() {

        abstract fun onGetHottelsReqest()

    }
}