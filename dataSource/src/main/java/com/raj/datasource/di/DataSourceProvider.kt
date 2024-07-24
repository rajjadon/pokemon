package com.raj.datasource.di

import android.content.Context
import androidx.room.Room
import com.raj.datasource.local.PokemonDataBase
import com.raj.datasource.remote.networkService.NetworkService
import com.raj.datasource.local.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceProvider {

    @Provides
    @Singleton
    fun provideRemoteDataSource(retrofit: Retrofit.Builder): NetworkService =
        retrofit.build().create(NetworkService::class.java)

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): PokemonDao {
        return Room.databaseBuilder(
            context,
            PokemonDataBase::class.java,
            "POKEMON_TABLE.db"
        ).fallbackToDestructiveMigration().build().pokemonDao
    }

}