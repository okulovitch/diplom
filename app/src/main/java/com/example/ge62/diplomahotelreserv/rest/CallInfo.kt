package com.example.ge62.diplomahotelreserv.rest

import retrofit2.Call

data class CallInfo<T>(var call: Call<T>, val callback: NetworkManager.NetworkCallback<T>)