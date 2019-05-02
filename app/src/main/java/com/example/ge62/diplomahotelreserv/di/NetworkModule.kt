package com.example.ge62.diplomahotelreserv.di

import android.content.Context
import com.example.ge62.diplomahotelreserv.rest.RestFactory
import com.example.ge62.diplomahotelreserv.rest.NetworkManager
import com.example.ge62.diplomahotelreserv.rest.RestClient
import com.example.ge62.diplomahotelreserv.storage.UserStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkManager(restClient: RestClient, userStorage: UserStorage, context: Context) = NetworkManager(restClient, userStorage, context)

    @Provides
    @Singleton
    fun provideRestFactory(userStorage: UserStorage) = RestFactory(userStorage)

    @Provides
    @Singleton
    fun provideRestClient(restFactory: RestFactory) = restFactory.client

}