package com.raj.datasource.remote

import com.raj.common.baseClasses.DataState
import com.raj.common.error.HttpRequestError
import com.raj.common.model.PokemonDetails
import com.raj.datasource.local.dao.PokemonDao
import com.raj.datasource.remote.network.SafeApiRequest
import com.raj.datasource.remote.network.networkService.NetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val safeApiRequest: SafeApiRequest,
    private val dao: PokemonDao,
    private val networkService: NetworkService
) : RemoteDataSource {
    private suspend fun insertAll(pokemonDetails: List<PokemonDetails>) {
        dao.insertAll(pokemonDetails)
    }

    override suspend fun getPokemonDetailsById(id: String): Flow<DataState<PokemonDetails>> = flow {
        emit(DataState.Loading)
        try {
            val data = dao.getPokemonDetailsById(id)

            emit(
                data?.let {
                    DataState.Success(it)
                } ?: run {
                    DataState.Error(
                        HttpRequestError.SomeThingWentWrong(
                            code = 1001,
                            errorMessage = "SomeThingWentWrong"
                        )
                    )
                }
            )
        } catch (e: Exception) {
            emit(
                DataState.Error(
                    HttpRequestError.SomeThingWentWrong(
                        code = e.hashCode(),
                        errorMessage = e.message.toString()
                    )
                )
            )
        }
    }

    override suspend fun getAllPokemonDetails(): Flow<DataState<List<PokemonDetails>>> = flow {
        emit(DataState.Loading)
        val result = safeApiRequest.apiRequest { networkService.getPokemonList() }
        val data = when (result) {
            is DataState.Error -> DataState.Error(result.exception)
            DataState.Loading -> DataState.Loading
            is DataState.Success -> {
                val domainData = result.baseResponseData.data.map { pokemonApiData ->
                    pokemonApiData.mapPokemonApiDataToPokemonDetails()
                }
                DataState.Success(domainData)
            }
        }

        if (data is DataState.Success)
            insertAll(data.baseResponseData)

        emit(data)
    }
}