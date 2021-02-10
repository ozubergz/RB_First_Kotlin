package com.example.rb_first_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.rb_first_kotlin.R
import com.example.rb_first_kotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getCountries.observe(this) {
            Toast.makeText(this, "List size is {it.size}", Toast.LENGTH_SHORT).show()
        }
    }
}