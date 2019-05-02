package com.example.ge62.diplomahotelreserv.rest.reqests

import com.example.ge62.diplomahotelreserv.models.Room
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AddHotelRequest (


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
        var longitude: String? = null,
        @SerializedName("latitude")
        @Expose
        var latitude: String? = null,
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