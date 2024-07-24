package com.raj.datasource.remote

import android.content.Context
import com.raj.common.qualifiers.ApiConstantEnum
import com.raj.common.qualifiers.ApiQualifier
import com.raj.datasource.remote.retrofitIntepceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        @ApplicationContext application: Context,
        @ApiQualifier(ApiConstantEnum.BASE_URL) baseUrl: String,
        authInterceptor: AuthInterceptor
    ): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(OkHttpClient().newBuilder().apply {

                callTimeout(40, TimeUnit.SECONDS)
                connectTimeout(40, TimeUnit.SECONDS)
                readTimeout(40, TimeUnit.SECONDS)
                writeTimeout(40, TimeUnit.SECONDS)
                addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                )
                cache(Cache(File(application.cacheDir, "http-cache"), 10L * 1024 * 1024))
                retryOnConnectionFailure(true)
                addInterceptor { chain ->
                    chain.proceed(
                        chain.request().newBuilder()
                            .header("Cache-Control", "public, max-age=" + 60).build()
                    )
                }
                addInterceptor(authInterceptor)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
    }
}