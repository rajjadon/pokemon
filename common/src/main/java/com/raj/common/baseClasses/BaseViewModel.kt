package com.raj.common.baseClasses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raj.common.error.PokemonAppError
import com.raj.common.extension.toSharedFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _loading = MutableSharedFlow<Boolean>()
    val loading = _loading.toSharedFlow()

    private val _pokemonAppError = MutableSharedFlow<PokemonAppError>()
    val pokemonAppError = _pokemonAppError.toSharedFlow()

    fun sendLoading(isLoading: Flow<Boolean>) {
        isLoading.onEach {
            _loading.emit(it)
        }.launchIn(viewModelScope)
    }

    fun sendError(pokemonAppError: Flow<PokemonAppError>) {
        pokemonAppError.onEach {
            _pokemonAppError.emit(it)
        }.launchIn(viewModelScope)
    }
}