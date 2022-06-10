package com.serioussem.globaltestproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.serioussem.globaltestproject.R
import com.serioussem.globaltestproject.data.model.ApiModel
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
//                updateView(it as ApiModel)
        }
    }
    private fun swipeRefresh() {
        binding.swipeRefreshContainer.setOnRefreshListener {
            viewModel.fetchData()
            binding.swipeRefreshContainer.isRefreshing = false
        }
    }

    private fun updateView(data: ApiModel){
        binding.textView.text = data.apiModel[0]?.ccy
    }

}