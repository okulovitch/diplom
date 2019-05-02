package com.example.ge62.diplomahotelreserv.rest.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthResponse {

    @SerializedName("role")
    @Expose
    var role:String? = null
    @SerializedName("tokenType")
    @Expose
    var tokenType:String? = null
    @SerializedName("accessToken")
    @Expose
    var token: String? = null

    fun getAccessToken(): String? {
        return token
    }
    fun setAccessToken() {
        this.token = token
    }

}
