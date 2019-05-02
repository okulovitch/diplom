package com.example.ge62.diplomahotelreserv.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Hotel(


    @SerializedName("hottelId")
    @Expose
    var hottelId: Int? = null,
    @SerializedName("phone")
    @Expose
    var phone: String? = null,
    @SerializedName("email")
    @Expose
    var email: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("hottelName")
    @Expose
    var hottelName: String? = null,
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null,
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null,
    @SerializedName("regionName")
    @Expose
    var regionName: String? = null,
    @SerializedName("rooms")
    @Expose
    var rooms: List<Room>? = null,
    @SerializedName("image")
    @Expose
    var image: String? = null

)