package com.example.ge62.diplomahotelreserv.rest.reqests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class AddRoomRequest (
        @SerializedName("roomNumberId")
        @Expose
        var bookId:Int? = null,
        @SerializedName("personsCount")
        @Expose
        var personsCount: Int? = null,
        @SerializedName("roomNumber")
        @Expose
        var roomNumber: Int? = null,
        @SerializedName("costForNight")
        @Expose
        var costForNight: Double? = null,
        @SerializedName("costWithSale")
        @Expose
        var costWithSale: Double? = null,
        @SerializedName("checkInDate")
        @Expose
        var checkInDate: String? = null,
        @SerializedName("checkOutDate")
        @Expose
        var checkOutDate: String? = null,
        @SerializedName("roomImage")
        @Expose
        var roomImage: String? = null,
        @SerializedName("roomLocation")
        @Expose
        var roomLocation: String? = null,
        @SerializedName("roomLongitude")
        @Expose
        var roomLongitude: Double? = null,
        @SerializedName("roomLatitude")
        @Expose
        var roomLatitude: Double? = null,
        @SerializedName("hot")
        @Expose
        var hot: Boolean? = null
    )