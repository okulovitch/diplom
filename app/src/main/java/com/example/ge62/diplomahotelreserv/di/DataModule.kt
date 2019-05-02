package com.example.ge62.diplomahotelreserv.di

import android.content.Context
import com.example.ge62.diplomahotelreserv.managers.DataManager
import com.example.ge62.diplomahotelreserv.storage.UserStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataManager(context: Context, userStorage: UserStorage) = DataManager(context, userStorage)

}