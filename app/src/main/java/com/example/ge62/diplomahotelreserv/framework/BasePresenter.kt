package com.example.ge62.diplomahotelreserv.framework

import java.lang.ref.WeakReference

abstract class BasePresenter<V : MvpView> : Presenter<V> {

    private var viewRef: WeakReference<V>? = null

    override fun onAttachView(view: V) {
        viewRef = WeakReference(view)
    }

    override fun getView() = viewRef?.get()

    override fun onDetachView() {
        viewRef?.clear()
    }

    override fun release() {
        viewRef?.clear()
    }

}