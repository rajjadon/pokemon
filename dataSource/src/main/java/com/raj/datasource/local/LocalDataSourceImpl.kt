package com.raj.datasource.local

import com.raj.common.baseClasses.DataState
import com.raj.common.error.HttpRequestError
import com.raj.common.model.PokemonDetails
import com.raj.datasource.local.dao.PokemonDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: PokemonDao,
) : LocalDataSource {

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
        try {
            val data = dao.getAllPokemonDetails()

            data?.let {
                if (it.isNotEmpty())
                    emit(DataState.Success(it))
                else {
                    Timber.e("data not found")
                    emit(
                        DataState.Error(
                            HttpRequestError.SomeThingWentWrong(
                                code = 1001,
                                errorMessage = "data not found"
                            )
                        )
                    )
                }
            } ?: run {
                Timber.e("data not found")
                emit(
                    DataState.Error(
                        HttpRequestError.SomeThingWentWrong(
                            code = 1001,
                            errorMessage = "data not found"
                        )
                    )
                )
            }
        } catch (e: Exception) {
            Timber.e(e)
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
}