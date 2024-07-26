package com.raj.common.baseClasses

import androidx.lifecycle.viewModelScope
import com.raj.common.error.PokemonAppError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseUseCase<in Params, out ApiResponse> where ApiResponse : Any {

    val loadingChannel = Channel<Boolean>()

    val errorChannel = Channel<PokemonAppError>()

    abstract suspend fun run(
        params: Params,
        scope: CoroutineScope,
    ): Flow<DataState<ApiResponse>>

    inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invoke(
        dispatcher: CoroutineDispatcher,
        params: Params,
        baseViewModel: BaseViewModel,
        crossinline onResult: suspend (ApiResponse) -> Unit,
    ) {
        baseViewModel.sendError(
            errorChannel.consumeAsFlow(),
        )
        baseViewModel.sendLoading(loadingChannel.consumeAsFlow())

        baseViewModel.viewModelScope.launch(dispatcher) {
            run(params, this).onEach { apiResponseState ->
                when (apiResponseState) {
                    is DataState.Error -> {
                        loadingChannel.send(false)
                        errorChannel.send(apiResponseState.exception)
                    }

                    is DataState.Loading -> loadingChannel.send(true)
                    is DataState.Success -> {
                        loadingChannel.send(false)
                        onResult.invoke(apiResponseState.baseResponseData)
                    }
                }
            }.launchIn(this)
        }
    }
}