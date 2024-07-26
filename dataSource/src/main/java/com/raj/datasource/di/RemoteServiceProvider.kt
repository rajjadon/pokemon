package com.raj.datasource.di

import com.raj.datasource.remote.network.networkService.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteServiceProvider {

    @Provides
    @Singleton
    fun provideRemoteDataSource(retrofit: Retrofit.Builder): NetworkService =
        retrofit.build().create(NetworkService::class.java)
}