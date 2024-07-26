package com.raj.data

import com.raj.common.baseClasses.DataState
import com.raj.common.model.PokemonDetails
import com.raj.datasource.local.LocalDataSource
import com.raj.datasource.remote.RemoteDataSource
import com.raj.datasource.remote.network.networkHelper.NetworkHelper
import com.raj.domain.repo.PokemonRepo
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.internal.ChannelFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PokemonRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val networkHelper: NetworkHelper
) : PokemonRepo {
    override suspend fun getPokemonDetailsById(id: String): Flow<DataState<PokemonDetails>> = flow {
        val data = if (networkHelper.isNetworkConnected()){
            remoteDataSource.getPokemonDetailsById(id)
        }
        else
            localDataSource.getPokemonDetailsById(id)

        data.onEach {
            emit(it)
        }
    }

    override suspend fun getAllPokemonDetails(): Flow<DataState<List<PokemonDetails>>>  = flow{

        val data = if (networkHelper.isNetworkConnected()){
            remoteDataSource.getAllPokemonDetails()
        }
        else
            localDataSource.getAllPokemonDetails()

        data.onEach {
            emit(it)
        }
    }
}