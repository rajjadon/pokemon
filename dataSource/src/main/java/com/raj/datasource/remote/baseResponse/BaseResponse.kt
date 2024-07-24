package com.raj.datasource.remote.baseResponse

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("is_error")
    var isError: Boolean,

    @SerializedName("message")
    var message: String = "",

    @SerializedName("data")
    var data: T
)