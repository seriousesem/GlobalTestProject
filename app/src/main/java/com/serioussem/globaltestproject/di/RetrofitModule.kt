package com.serioussem.globaltestproject.di

import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import org.koin.dsl.module

private const val PRIVAT_BASE_URL = "https://api.privatbank.ua/p24api/"
private const val MONO_BASE_URL = "https://api.monobank.ua/"
private const val ANIME_BASE_URL = "https://anime-facts-rest-api.herokuapp.com/"

val retrofitModule = module {
    single {
        createLoggingInterceptor()
    }
    single {
        createOkHttpClient(get())
    }
    single{
        createRetrofit(get())
    }
    single{
        createRetrofitService(get())
    }

}

fun createLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun createOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        .callTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(MONO_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

fun createRetrofitService(retrofit: Retrofit): RetrofitService =
    retrofit.create(RetrofitService::class.java)

