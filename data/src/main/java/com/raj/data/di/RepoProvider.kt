package com.raj.data.di

import com.raj.data.PokemonRepoImpl
import com.raj.domain.repo.PokemonRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoProvider {

    @Singleton
    @Binds
    abstract fun bindsPokemonRepo(pokemonRepoImpl: PokemonRepoImpl) : PokemonRepo
}