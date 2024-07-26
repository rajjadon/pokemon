package com.raj.common.baseClasses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.common.error.PokemonAppError
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _loading = MutableSharedFlow<Boolean>(replay = 1)
    val loading: SharedFlow<Boolean> = _loading.asSharedFlow()

    private val _pokemonAppError = MutableSharedFlow<PokemonAppError>(replay = 1)
    val pokemonAppError: SharedFlow<PokemonAppError> = _pokemonAppError.asSharedFlow()

    fun sendLoading(isLoading: Flow<Boolean>) {
        viewModelScope.launch {
            isLoading.collect {
                _loading.emit(it)
            }
        }
    }

    fun sendError(pokemonAppError: Flow<PokemonAppError>) {
        viewModelScope.launch {
            pokemonAppError.collect {
                _pokemonAppError.emit(it)
            }
        }
    }

    fun sendError(pokemonAppError: PokemonAppError) {
        viewModelScope.launch {
            _pokemonAppError.emit(pokemonAppError)
        }
    }

    fun setLoading(isLoading: Boolean) {
        viewModelScope.launch {
            _loading.emit(isLoading)
        }
    }
}