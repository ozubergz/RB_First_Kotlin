package com.example.rb_first_kotlin.view

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rb_first_kotlin.adapter.Adapter
import com.example.rb_first_kotlin.databinding.ActivityMainBinding
import com.example.rb_first_kotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.countries.observe(this) {
//            Toast.makeText(this, "SVG is ${it[0].flag}", Toast.LENGTH_SHORT).show()
            binding.rvList.adapter = Adapter(it)
            binding.rvList.layoutManager = GridLayoutManager(this, 3)

        }
    }
}