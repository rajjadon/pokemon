package com.raj.common.baseClasses

import com.raj.common.error.TrailerAppError

sealed class DataState<out T> {
    data class Success<out T>(val baseResponseData: T) : DataState<T>()
    data class Error(val exception: TrailerAppError) :
        DataState<Nothing>()

    object Loading : DataState<Nothing>()
}