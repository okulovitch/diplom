package com.example.ge62.diplomahotelreserv.rest

import android.content.Context
import android.net.ConnectivityManager
import com.example.ge62.diplomahotelreserv.models.Hotel
import com.example.ge62.diplomahotelreserv.models.Room
import com.example.ge62.diplomahotelreserv.rest.reqests.AddHotelRequest
import com.example.ge62.diplomahotelreserv.rest.reqests.AddRoomRequest
import com.example.ge62.diplomahotelreserv.rest.reqests.SignInReqest
import com.example.ge62.diplomahotelreserv.rest.reqests.SignUpReqest
import com.example.ge62.diplomahotelreserv.rest.responses.AuthResponse
import com.example.ge62.diplomahotelreserv.rest.responses.ErrorResponse
import com.example.ge62.diplomahotelreserv.storage.UserStorage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkManager(val restClient: RestClient, val userStorage: UserStorage, val context: Context) {

    fun checkSession(callback: NetworkCallback<AuthResponse>) {

        callback.setAdditionSuccessCallback {
            userStorage.saveToken(it.token!!)
        }

        enqueue(restClient.checkSession(), callback)
    }


    fun login(username:String,password:String, callback: NetworkManager.NetworkCallback<AuthResponse>){
        enqueue(restClient.login(SignInReqest(username,password)),callback)
    }

    fun register(username: String,password: String,email: String,firstName: String,callback: NetworkCallback<ResponseBody>){
        enqueue((restClient.register(SignUpReqest(username,firstName,email,password))),callback)
    }

    fun getAllHottels(callback: NetworkCallback<List<Hotel>>){
        enqueue(restClient.getHottelsList(),callback)
    }
    fun getAllHotRooms(callback: NetworkCallback<List<Room>>)
    {
        enqueue(restClient.getHotRoomsList(),callback)
    }
    fun deleteHotel(bookId: Int,callback : NetworkCallback<ResponseBody>){
        enqueue(restClient.deleteHotel(bookId),callback)
    }
    fun addHotel(phone: String,email: String, description: String,hotelName: String,longitude: String,latitude: String,regionName: String,image: String,callback: NetworkCallback<ResponseBody>){
        enqueue((restClient.addHotel(AddHotelRequest(phone, email, description,hotelName,longitude,latitude,regionName,null,image))),callback)
    }

    fun addRoomByHotelId(bookId: Int,roomNumber:Int, costForNight:Double, costWithSale: Double, checkInDate:String, checkOutDate:String, roomImage:String,roomLocation:String, personsCount: Int,roomLongitude: Double,
                         roomLatitude: Double, hot: Boolean,callback: NetworkCallback<ResponseBody>){
        enqueue(restClient.addRoomByHotelId((bookId),AddRoomRequest(bookId, personsCount, roomNumber, costForNight, costWithSale, checkInDate, checkOutDate, roomImage, roomLocation, roomLongitude, roomLatitude, hot)),callback)
    }

    fun <T> enqueue(call: Call<T>, result: NetworkCallback<T>?) : Call<T> {

        if(!isOnline()) {
            result?.onOffline(this, CallInfo(call, result))
            return call
        }

        result?.onRequestStart()

        call.enqueue(object : Callback<T> {

            override fun onResponse(call: Call<T>, response: Response<T>) {
                result?.onRequestFinish()

                if (response.isSuccessful) {
                    response.body()?.let { result?.onResult(it) }
                } else {
                    if(response.code() == 500 || response.code() == 502) {
                        result?.onFailure("500")
                    } else {
                        try {
                            result?.onUnsuccessfulResult(
                                    Gson().fromJson(
                                            response.errorBody()?.string(),
                                            object : TypeToken<ErrorResponse>() {}.type
                                    )
                            )
                        } catch (e: Exception) {
                            result?.onFailure("UnsuccessfulResult")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                t.printStackTrace()
                result?.onRequestFinish()
                if(t.message != null) {
                    result?.onFailure(t.message!!)
                } else result?.onFailure("ERROR")
            }
        })

        return call
    }

    fun isOnline() : Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    interface NetworkCallback<T> {
        fun onRequestStart()
        fun onResult(data: T)
        fun onUnsuccessfulResult(response: ErrorResponse)
        fun onFailure(message: String)
        fun onRequestFinish()
        fun onRequestCompleted(isSuccess: Boolean)
        fun onOffline(networkManager: NetworkManager, callInfo: CallInfo<T>)

        fun setAdditionSuccessCallback(callback: (data: T) -> Unit)
    }

}



