package com.example.ge62.diplomahotelreserv.rest

import com.example.ge62.diplomahotelreserv.BuildConfig
import com.example.ge62.diplomahotelreserv.storage.UserStorage
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestFactory(val userStorage: UserStorage) {

    companion object {
        private val TIMEOUT: Long = 60
        private val X_TOKEN = "Authorization"
    }

    val client: RestClient
        get() {
            val retrofit = getRetrofit(okHttpClientAuthorization)
            return retrofit.create(RestClient::class.java)
        }

    private val okHttpClientAuthorization: OkHttpClient
        get() {
            val defaultHttpClient = OkHttpClient.Builder()

            val interceptor = HttpLoggingInterceptor()
            interceptor.level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            defaultHttpClient.addInterceptor(interceptor)

            defaultHttpClient.addInterceptor { chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder()

                val token = userStorage.getToken()

                if(token != null)
                    requestBuilder.header(X_TOKEN,token)

                requestBuilder.header("Accept", "application/json")
                        .method(original.method(), original.body())


                chain.proceed(requestBuilder.build())
            }

            defaultHttpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS)
            defaultHttpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            defaultHttpClient.writeTimeout(TIMEOUT, TimeUnit.SECONDS)

            return defaultHttpClient.build()
        }

    private fun getRetrofit(client: OkHttpClient): Retrofit {

        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").setLenient().create()

        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}