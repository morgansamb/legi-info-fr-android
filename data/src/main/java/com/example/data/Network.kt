package com.example.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.reflect.KClass

class Network(
    baseUrl: String
) {

    private val client by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(
                MoshiConverterFactory.create()
            )
            .build()

    fun <T: Any> createAPIService(apiClass: KClass<T>): T {
        return retrofit.create(apiClass.java)
    }
}
