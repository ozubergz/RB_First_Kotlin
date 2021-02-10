package com.example.rb_first_kotlin.rep

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * object keyword - singleton
 * const - static;
 * **/
object RetrofitInstance {

    private const val BASE_URL = "https://restcountries.eu/rest/v2/"

    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        .let {
            OkHttpClient.Builder().addInterceptor(it).build()
        }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val service: Service by lazy { retrofit.create(Service::class.java) }
}