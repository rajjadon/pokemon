package com.raj.data

import com.raj.common.baseClasses.DataState
import com.raj.common.model.PokemonDetails
import com.raj.domain.repo.PokemonRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class PokemonRepoImpl @Inject constructor() : PokemonRepo {
    override suspend fun getPokemonDetailsById(id: String): Flow<DataState<PokemonDetails>> = flow{
        Timber.e("Not yet implemented")
    }

    override suspend fun getAllPokemonDetails(): Flow<DataState<List<PokemonDetails>>> = flow{
        Timber.e("Not yet implemented")
    }
}