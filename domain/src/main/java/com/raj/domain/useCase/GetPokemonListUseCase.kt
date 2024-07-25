package com.raj.domain.useCase

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.DataState
import com.raj.common.model.PokemonDetails
import com.raj.domain.repo.PokemonRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val pokemonRepo: PokemonRepo) :
    BaseUseCase<Unit, List<PokemonDetails>>() {
    override suspend fun run(
        params: Unit,
        scope: CoroutineScope
    ): Flow<DataState<List<PokemonDetails>>> {
        return pokemonRepo.getAllPokemonDetails()
    }
}