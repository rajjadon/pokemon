package com.raj.datasource.local

import com.raj.common.baseClasses.DataState
import com.raj.common.model.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getPokemonDetailsById(id: String) : Flow<DataState<PokemonDetails>>
    suspend fun getAllPokemonDetails(): Flow<DataState<List<PokemonDetails>>>
}