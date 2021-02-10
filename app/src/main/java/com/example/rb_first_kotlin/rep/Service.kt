package com.example.rb_first_kotlin.rep

import com.example.rb_first_kotlin.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    // https://restcountries.eu/rest/v2/name/{name}

    @GET("name/{name}")
    fun getCountries(@Path("name") name : String) : Call<List<Country>>

}