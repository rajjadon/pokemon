package com.raj.common.extension

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.BaseViewModel
import kotlinx.coroutines.Dispatchers

inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invokeOnIO(
    params: Params,
    baseViewModel: BaseViewModel,
    crossinline onResult: suspend (ApiResponse) -> Unit = {}
) = run {
    invoke(
        dispatcher = Dispatchers.IO,
        params = params,
        baseViewModel = baseViewModel,
        onResult = onResult,
    )
}