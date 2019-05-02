package com.example.ge62.diplomahotelreserv.storage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers





class UserStorage(context: Context) {

    companion object {
//        val COMPANIES_KEY = "companies"
        val USER_DETAILS_KEY = "user_details"
//        val PERMISSIONS_KEY = "permissions"
        val TOKEN_KEY = "token"
    }

    private val sharedPreferences: SharedPreferences
    private val gson: Gson

    init {
        sharedPreferences = context.getSharedPreferences(this::class.java.simpleName, Context.MODE_PRIVATE)
        gson = Gson()
    }


    private var token: String? = null



    fun saveToken(token: String) {
        Observable.fromCallable { setToken(token) }.observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe()
    }




     fun setToken(token: String) {
        this.token = token
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }



    fun getToken(): String? {
       // sharedPreferences.getString(TOKEN_KEY,"Breaer " + token)

            var tokenWithBreaer="Bearer "+token
            return tokenWithBreaer


    }
}