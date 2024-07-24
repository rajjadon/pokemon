package com.raj.datasource.remote.retrofitIntepceptor

import com.raj.common.qualifiers.ApiConstantEnum
import com.raj.common.qualifiers.ApiQualifier
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(@ApiQualifier(ApiConstantEnum.ACCESS_TOKEN) private val accessToken: String) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        run {
            request.header("content-Type", "application/json")
            request.header("Authorization", accessToken)
        }
        return chain.proceed(request.build())
    }
}