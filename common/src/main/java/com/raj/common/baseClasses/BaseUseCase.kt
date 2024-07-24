package com.raj.common.baseClasses

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseUseCase<in Params, out ApiResponse> where ApiResponse : Any {

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
        baseViewModel.viewModelScope.launch(dispatcher) {
            run(params, this).onEach { apiResponseState ->
                when (apiResponseState) {
                    is DataState.Error -> {
                        baseViewModel.sendLoading(false)
                        baseViewModel.sendError(apiResponseState.exception)
                    }

                    is DataState.Loading -> baseViewModel.sendLoading(true)
                    is DataState.Success -> {
                        baseViewModel.sendLoading(false)
                        onResult.invoke(apiResponseState.baseResponseData)
                    }
                }
            }.launchIn(this)
        }
    }
}