package com.example.ge62.diplomahotelreserv.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(context: Context) {

    private var appContext = context

    @Provides
    fun provideContext() = appContext

}