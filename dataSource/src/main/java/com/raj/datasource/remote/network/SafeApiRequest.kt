package com.raj.datasource.remote.network

import com.raj.common.baseClasses.DataState
import com.raj.common.error.HttpRequestError
import com.raj.common.error.HttpRequestErrorCodes
import com.raj.datasource.remote.network.networkHelper.NetworkHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject

open class SafeApiRequest
@Inject constructor(
    private val networkHelper: NetworkHelper
) {
    suspend fun <T : Any> apiRequest(
        maxRetry: Int = RetrialPolicy.Max.retryNum,
        retry: Int = RetrialPolicy.Default.retryNum,
        enableRetry: Boolean = false,
        apiCall: suspend () -> T
    ): DataState<T> {

        return when (val data =
            internalApiRequest(dataRequest = apiCall)) {
            is DataState.Success -> data
            is DataState.Error -> {
                if (enableRetry && retry < maxRetry) {
                    apiRequest(maxRetry = maxRetry, retry + 1, apiCall = apiCall)
                } else
                    data
            }

            DataState.Loading -> DataState.Loading
        }
    }

    private suspend inline fun <T : Any> internalApiRequest(
        crossinline dataRequest: suspend () -> T,
    ): DataState<T> {
        return try {
            if (networkHelper.isNetworkConnected()) {
                val response = withContext(Dispatchers.IO) { dataRequest.invoke() }
                DataState.Success(response)
            } else
                DataState.Error(HttpRequestError.NoInternet())

        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    DataState.Error(getErrorMessage(throwable.code()))
                }

                is SocketTimeoutException -> DataState.Error(
                    getErrorMessage(HttpRequestErrorCodes.TimeOut.code)
                )

                else -> {
                    DataState.Error(getErrorMessage(throwable.hashCode()))
                }
            }
        }
    }
}