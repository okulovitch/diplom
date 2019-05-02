package com.example.ge62.diplomahotelreserv

import android.app.Application
import com.example.ge62.diplomahotelreserv.di.*
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration

class BookingApp:Application() {

    companion object {
        private lateinit var component: AppComponent
        fun getAppComponent() = component
    }

    override fun onCreate() {
        super.onCreate()

        //Fabric.with(this, Crashlytics())

        buildDIComponent()
        initUniversalImageLoader()

    }

    private fun initUniversalImageLoader() {
        val configBuilder = ImageLoaderConfiguration.Builder(this)
        val option = DisplayImageOptions.Builder().build()

        configBuilder.defaultDisplayImageOptions(option)
        configBuilder.threadPoolSize(3)

        ImageLoader.getInstance().init(configBuilder.build())


    }
    fun buildDIComponent() {
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .storageModule(StorageModule())
                .networkModule(NetworkModule())
                .build()
    }
}