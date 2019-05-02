package com.example.ge62.diplomahotelreserv.rest

import com.example.ge62.diplomahotelreserv.models.Hotel
import com.example.ge62.diplomahotelreserv.models.Room
import com.example.ge62.diplomahotelreserv.rest.reqests.AddHotelRequest
import com.example.ge62.diplomahotelreserv.rest.reqests.AddRoomRequest
import com.example.ge62.diplomahotelreserv.rest.reqests.SignInReqest
import com.example.ge62.diplomahotelreserv.rest.reqests.SignUpReqest
import com.example.ge62.diplomahotelreserv.rest.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RestClient {
    companion object {

    const val LOGIN_URL ="api/v1/signin"
    const val REGISTER_URL ="api/v1/signup"
        const val GET_ALL_HOTTELS = "api/v1/getHottels"
        const val ADD_HOTEL = "api/v1/addHottel"
        const val DELETE_ROOM_BY_HOTELID_AND_ROOMID ="/bookings/{bookId}/rooms/{roomId}"
        const val ADD_ROOM_BY_HOTELID= "api/v1/addroom/{bookId}"
        const val DELETE_HOTEL_BY_HOTELID = "api/v1/booking/{bookId}"
        const val GET_ALL_HOT_ROOMS="api/v1/rooms"
    }

    fun checkSession(): Call<AuthResponse>

    @POST(LOGIN_URL)
    fun login(@Body body:SignInReqest):Call<AuthResponse>

    @POST(REGISTER_URL)
    fun register(@Body body: SignUpReqest):Call<ResponseBody>

    @POST(ADD_ROOM_BY_HOTELID)
    fun addRoomByHotelId(@Path("bookId")bookId: Int,@Body body:AddRoomRequest):Call<ResponseBody>

    @GET(GET_ALL_HOTTELS)
    fun getHottelsList():Call<List<Hotel>>

    @POST(ADD_HOTEL)
    fun addHotel(@Body body: AddHotelRequest):Call<ResponseBody>

    @DELETE(DELETE_HOTEL_BY_HOTELID)
    fun deleteHotel(@Path("bookId")bookId: Int):Call<ResponseBody>

    @GET(GET_ALL_HOT_ROOMS)
    fun getHotRoomsList():Call<List<Room>>


}