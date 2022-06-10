package com.serioussem.globaltestproject.domain.repository

import com.serioussem.globaltestproject.data.model.ApiModel
import retrofit2.Response

interface Repository {
   suspend fun fetchData(): ApiModel?
}