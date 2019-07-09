package com.alpha.neworg.data

import com.alpha.neworg.data.networking.EndPoints
import com.alpha.neworg.utilites.ConstantUtils
import java.io.IOException
import java.util.concurrent.TimeUnit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroClient {

    private var retrofit: EndPoints? = null
    private val REQUEST_TIMEOUT = 60
    private var okHttpClient: OkHttpClient? = null


    fun getClient(): EndPoints {

        if (okHttpClient == null)
            initOkHttp()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(ConstantUtils.EndPoint)
                .client(okHttpClient!!)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPoints::class.java)
        }

        return retrofit!!
    }


    private fun initOkHttp() {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(interceptor)

        httpClient.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")

                // Adding Authorization token (API Key)
                // Requests will be denied without API key
                /*if (!TextUtils.isEmpty(PrefUtils.getApiKey(context))) {
                    requestBuilder.addHeader("Authorization", PrefUtils.getApiKey(context))
                }*/

                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        })

        okHttpClient = httpClient.build()
    }

}
