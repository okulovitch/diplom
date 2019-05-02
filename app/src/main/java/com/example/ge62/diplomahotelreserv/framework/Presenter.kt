package com.example.ge62.diplomahotelreserv.framework

interface Presenter <V :MvpView>{

    fun onAttachView(view: V)
    fun onDetachView()
    fun release()
    fun getView() : V?
}