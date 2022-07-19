package com.serioussem.globaltestproject.di

import com.serioussem.globaltestproject.data.jsoup.JsoupService
import com.serioussem.globaltestproject.data.repository.RepositoryImpl
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
        service: JsoupService
    ): Repository = RepositoryImpl( service = service)
}