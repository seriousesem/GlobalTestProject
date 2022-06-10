package com.serioussem.globaltestproject.data.repository

import android.util.Log
import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.data.model.ApiModelItem
import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import com.serioussem.globaltestproject.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: RetrofitService) : Repository {
    override suspend fun fetchData(): MonoModel? =
    try {
        Log.d("Sem", "${service.fetchData().isSuccessful}")
        service.fetchData().body()
    }catch (e: Exception) {
        MonoModel(listOf())
    }

}