package com.example.ge62.diplomahotelreserv.di

import android.content.Context
import com.example.ge62.diplomahotelreserv.storage.UserStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    fun provideUserStorage(context: Context) = UserStorage(context)

}