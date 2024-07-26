package com.raj.common.baseClasses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.common.error.PokemonAppError
import com.raj.common.extension.toSharedFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _loading = MutableSharedFlow<Boolean>()
    val loading = _loading.toSharedFlow()

    private val _pokemonAppError = MutableSharedFlow<PokemonAppError>()
    val pokemonAppError = _pokemonAppError.toSharedFlow()

    fun sendLoading(isLoading: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.emit(isLoading)
        }
    }

    fun sendError(trailerAppError: PokemonAppError) {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonAppError.emit(trailerAppError)
        }
    }
}