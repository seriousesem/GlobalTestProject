package com.serioussem.globaltestproject.data.repository

import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.data.model.ApiModelItem
import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import com.serioussem.globaltestproject.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: RetrofitService) : Repository {
    override suspend fun fetchData(): ApiModel? =
    try {
        service.fetchData().body()
    }catch (e: Exception) {
        ApiModel(listOf(ApiModelItem(sale = "35", baseCcy = "uk", buy = "30", ccy = "usa")))
    }

}