package com.raj.datasource.remote.network.networkService

import com.raj.common.model.PokemonDetails
import com.raj.datasource.BuildConfig
import com.raj.datasource.remote.network.baseResponse.BaseResponse
import com.raj.datasource.remote.network.model.PokemonApiData
import retrofit2.http.GET

interface NetworkService {

    @GET(BuildConfig.POKEMON_LIST)
    suspend fun getPokemonList(): BaseResponse<List<PokemonApiData>>
}
