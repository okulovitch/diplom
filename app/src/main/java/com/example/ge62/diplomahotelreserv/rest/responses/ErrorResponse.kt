package com.example.ge62.diplomahotelreserv.rest.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorResponse {

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

//    @SerializedName("details")
//    @Expose
//    var details: Any? = null
}