package com.example.ge62.diplomahotelreserv.rest.reqests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenRequest(@SerializedName("token")
                   @Expose
                   var token: String? = null)