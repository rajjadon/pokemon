package com.raj.datasource.di

import android.content.Context
import androidx.room.Room
import com.raj.datasource.local.dao.PokemonDao
import com.raj.datasource.local.dao.PokemonDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonDataBase {
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