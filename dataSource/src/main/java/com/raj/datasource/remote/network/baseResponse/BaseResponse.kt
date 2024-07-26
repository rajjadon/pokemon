package com.raj.datasource.remote.network.baseResponse

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    var data: T
)