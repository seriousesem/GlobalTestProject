package com.serioussem.globaltestproject.data.repository

import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.data.retrofit.RetrofitService
import com.serioussem.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: RetrofitService) : Repository {
    override suspend fun fetchData(): ApiModel = service.fetchData()
}