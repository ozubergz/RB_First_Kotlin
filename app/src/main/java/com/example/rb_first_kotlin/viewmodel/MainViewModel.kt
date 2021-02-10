package com.example.rb_first_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rb_first_kotlin.model.Country
import com.example.rb_first_kotlin.rep.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>();

    val getCountries: LiveData<List<Country>>
        get() = _countries

    init {

        Repo.service.getCountries("united").enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                _countries.value = response.body()
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e("MainViewModel", "onFailure: ", t)
            }
        })
    }
}

