package com.serioussem.globaltestproject.domain.repository

import com.serioussem.globaltestproject.data.model.ApiModel

interface Repository {
   suspend fun fetchData(): ApiModel
}