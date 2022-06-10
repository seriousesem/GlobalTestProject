package com.serioussem.globaltestproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serioussem.globaltestproject.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        initObservers()
    }
    private fun initObservers() {
        viewModel.data.observe(this@MainActivity) {
            binding.textView.text = it.toString()
        }
    }
    private fun initData() {
        viewModel.fetchData()
    }
}