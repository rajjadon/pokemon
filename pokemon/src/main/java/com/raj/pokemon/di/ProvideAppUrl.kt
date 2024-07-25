package com.raj.pokemon.di

import com.raj.common.qualifiers.ApiConstantEnum
import com.raj.common.qualifiers.ApiQualifier
import com.raj.pokemon.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProvideAppUrl {

    @Provides
    @ApiQualifier(ApiConstantEnum.BASE_URL)
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @ApiQualifier(ApiConstantEnum.ACCESS_TOKEN)
    fun provideAccessToken() = "Bearer"

    @Provides
    @ApiQualifier(ApiConstantEnum.POKEMON_LIST)
    fun provideApiKey() = BuildConfig.POKEMON_LIST
}