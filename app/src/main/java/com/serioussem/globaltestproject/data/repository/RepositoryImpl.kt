package com.serioussem.globaltestproject.data.repository

import android.util.Log
import com.serioussem.globaltestproject.data.model.AnimeModel
import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import com.serioussem.globaltestproject.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: RetrofitService) : Repository {
    override suspend fun fetchData(): List<ApiModel> =
        try {
            val response = service.fetchData()
            val body = response.body()
            Log.d("Sem", "${response.isSuccessful}")
            Log.d("Sem", "$body")
            body!!
        }catch (e: Exception) {
            Log.d("Sem", e.message.toString())
            listOf<ApiModel>()
        }



}