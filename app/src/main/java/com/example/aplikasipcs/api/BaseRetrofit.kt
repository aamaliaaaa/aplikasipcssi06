package com.example.aplikasipcs.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseRetrofit {
    val endpoint : ApiEndpoint
        get(){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrtofit = Retrofit.Builder()
                .baseUrl("http://pcs.donnipra.com/index.php/api_pcs/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrtofit.create(ApiEndpoint::class.java)
        }
}