package com.serioussem.globaltestproject.di

import com.serioussem.globaltestproject.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(get())
    }
}