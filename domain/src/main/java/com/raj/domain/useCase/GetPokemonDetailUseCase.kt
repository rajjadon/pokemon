package com.raj.domain.useCase

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.DataState
import com.raj.common.model.PokemonDetails
import com.raj.domain.repo.PokemonRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val pokemonRepo: PokemonRepo) :
    BaseUseCase<String, PokemonDetails>() {
    override suspend fun run(
        params: String,
        scope: CoroutineScope
    ): Flow<DataState<PokemonDetails>> {
        return pokemonRepo.getPokemonDetailsById(id = params)
    }
}