package com.serioussem.globaltestproject.data.retrofit

import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.data.model.PrivatModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    companion object {
        private const val PRIVAT_ENDPOINT = "pubinfo?json&exchange&coursid=5"
        private const val MONO_ENDPOINT = "bank/currency"
        private const val ANIME_ENDPOINT = "api/v1"
    }

    @GET(MONO_ENDPOINT)
    suspend fun fetchData(): Response<List<MonoModel>>
}
