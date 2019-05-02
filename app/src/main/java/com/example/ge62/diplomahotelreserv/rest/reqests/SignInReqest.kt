package com.example.ge62.diplomahotelreserv.rest.reqests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SignInReqest (
    @SerializedName("username")
    @Expose
    private val username: String? = null,
    @SerializedName("password")
    @Expose
    private val password: String? = null
)