package com.serioussem.globaltestproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.serioussem.globaltestproject.R
import com.serioussem.globaltestproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefresh()
        initObservers()
    }

    private fun initObservers() {
        viewModel.data.observe(this@MainActivity){
            it?.monoModel?.forEach {item ->
                Log.d("Sem", "$item")
                binding.content.text = item.toString()
            }
        }
    }
    private fun swipeRefresh() {
        binding.swipeRefreshContainer.setOnRefreshListener {
            viewModel.fetchData()
            binding.swipeRefreshContainer.isRefreshing = false
        }
    }
}