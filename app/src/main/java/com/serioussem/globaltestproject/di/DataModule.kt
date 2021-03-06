package com.serioussem.globaltestproject.di

import com.serioussem.globaltestproject.data.repository.RepositoryImpl
import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import com.serioussem.globaltestproject.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideRepository(
        service: RetrofitService
    ): Repository = RepositoryImpl( service = service)
}