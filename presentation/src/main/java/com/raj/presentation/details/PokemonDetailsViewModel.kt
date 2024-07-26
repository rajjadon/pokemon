package com.raj.presentation.details

import com.raj.common.baseClasses.BaseViewModel
import com.raj.common.extension.invokeOnIO
import com.raj.common.extension.toSharedFlow
import com.raj.common.model.PokemonDetails
import com.raj.domain.useCase.GetPokemonDetailUseCase
import com.raj.domain.useCase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(private val getPokemonDetailUseCase: GetPokemonDetailUseCase) :
    BaseViewModel() {

    private val _pokemonDetail = MutableSharedFlow<PokemonDetails>()
    val pokemonDetails = _pokemonDetail.toSharedFlow()

    fun fetchPokemonDetail(id:String) {
        getPokemonDetailUseCase.invokeOnIO(
            params = id,
            baseViewModel = this,
            onResult = {
                _pokemonDetail.emit(it)
            },
        )
    }
}