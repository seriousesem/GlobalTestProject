package com.serioussem.globaltestproject.data.repository

import android.util.Log
import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.data.model.PrivatModel
import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import com.serioussem.globaltestproject.domain.repository.Repository

class RepositoryImpl (private val service: RetrofitService) : Repository {
    override suspend fun fetchData(): List<MonoModel> =
        try {
            val response = service.fetchData()
            val body = response.body()
            body!!
        }catch (e: Exception) {
            Log.d("Sem", e.message.toString())
            listOf<MonoModel>()
        }



}