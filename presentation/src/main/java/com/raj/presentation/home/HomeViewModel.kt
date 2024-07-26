package com.raj.presentation.home

import com.raj.common.baseClasses.BaseViewModel
import com.raj.common.extension.invokeOnIO
import com.raj.common.extension.toSharedFlow
import com.raj.common.model.PokemonDetails
import com.raj.domain.useCase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPokemonListUseCase: GetPokemonListUseCase) :
    BaseViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonDetails>>(emptyList())
    val pokemonList = _pokemonList.toSharedFlow()

    fun fetchPokemon() {
        getPokemonListUseCase.invokeOnIO(
            params = Unit,
            baseViewModel = this,
            onResult = {
                _pokemonList.emit(it)
            },
        )
    }
}