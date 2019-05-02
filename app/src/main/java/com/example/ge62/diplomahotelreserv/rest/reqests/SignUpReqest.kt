package com.example.ge62.diplomahotelreserv.rest.reqests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class SignUpReqest (
    @SerializedName("name")
    @Expose
    private val name: String? = null,
    @SerializedName("username")
    @Expose
//    private val username: String? = null,
//    @SerializedName("lastName")
//    @Expose
    private val lastName: String? = null,
    @SerializedName("email")
    @Expose
    private val email: String? = null,
    @SerializedName("password")
    @Expose
    private val password: String? = null
//    @SerializedName("phone")
//    @Expose
//    private val phone: String? = null
)