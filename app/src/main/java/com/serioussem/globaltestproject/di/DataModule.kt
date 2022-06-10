package com.serioussem.globaltestproject.di

import com.serioussem.globaltestproject.data.repository.RepositoryImpl
import com.serioussem.globaltestproject.domain.repository.Repository
import org.koin.dsl.module


val dataModule = module{
    factory<Repository> {
        RepositoryImpl(get())
    }

}