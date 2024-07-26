package com.raj.data

import com.raj.common.baseClasses.DataState
import com.raj.common.model.PokemonDetails
import com.raj.datasource.local.PokemonDao
import com.raj.datasource.remote.SafeApiRequest
import com.raj.datasource.remote.networkHelper.NetworkHelper
import com.raj.datasource.remote.networkService.NetworkService
import com.raj.domain.repo.PokemonRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class PokemonRepoImpl @Inject constructor(
    private val safeApiRequest: SafeApiRequest,
    private val networkHelper: NetworkHelper,
    private val dao: PokemonDao,
    private val networkService: NetworkService
) : PokemonRepo {
    override suspend fun getPokemonDetailsById(id: String): Flow<DataState<PokemonDetails>> = flow {
        Timber.e("Not yet implemented")
    }

    override suspend fun getAllPokemonDetails(): Flow<DataState<List<PokemonDetails>>>  = flow{
        //emit(DataState.Loading)

        val f = safeApiRequest.apiRequest { networkService.getPokemonList() }

        val data = if (networkHelper.isNetworkConnected())
            safeApiRequest.apiRequest { networkService.getPokemonList() }
        else
            DataState.Success(dao.getAllPokemonDetails())

        val s = DataState.Success(dao.getAllPokemonDetails())

        Timber.e("Not yet implemented")
    }
}