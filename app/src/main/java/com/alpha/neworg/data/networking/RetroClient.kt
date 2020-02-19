package com.alpha.neworg.data.networking

import com.alpha.neworg.BuildConfig
import com.alpha.neworg.utilites.ConstantUtils.EndPoint
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {

    private val httpLogging: HttpLoggingInterceptor
    private val httpHeader: Interceptor
    private val okHttpClient: OkHttpClient

    init {

        httpHeader = provideInterceptorsHeaders()
        httpLogging = provideLoggingInterceptor()
        okHttpClient = provideOkHttpClient()

    }

    fun provideApi(): EndPoints = Retrofit.Builder()
        .baseUrl(EndPoint)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EndPoints::class.java)



    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder()
            .run {
                addInterceptor(httpLogging)
                addInterceptor(httpHeader)
            }.build()

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }




    private fun provideInterceptorsHeaders(): Interceptor = Interceptor.invoke {
        val original = it.request()


        val requestBuilder = original.newBuilder()
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")


        val request = requestBuilder.build()
        it.proceed(request)
    }
}

