package com.example.ge62.diplomahotelreserv.rest

import com.example.ge62.diplomahotelreserv.framework.MvpView
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import java.lang.ref.WeakReference

abstract class SmartNetworkCallback<T>(view: MvpView? = null, val showProgress: Boolean = true) : NetworkManager.NetworkCallback<T> {

    private val viewRef = WeakReference<MvpView>(view)

    private var successCallbackRef: WeakReference<(data: T) -> Unit>? = null

    override fun onRequestStart() {
      //  if(showProgress)
         //   viewRef.get()?.showProgressView()
    }

    override fun onResult(data: T) {
        successCallbackRef?.get()?.invoke(data)
    }

    override fun onUnsuccessfulResult(response: ErrorResponse) { }

    override fun onFailure(message: String) { }

    override fun onRequestFinish() {
     //   if(showProgress)
          //  viewRef.get()?.hideProgressView()
    }

    override fun onRequestCompleted(isSuccess: Boolean) { }

    override fun onOffline(networkManager: NetworkManager, callInfo: CallInfo<T>) {
        //viewRef.get()?.showNoNetworkBar(networkManager, callInfo)
    }

    override fun setAdditionSuccessCallback(callback: (data: T) -> Unit) {
        successCallbackRef = WeakReference(callback)
    }

}