package com.serioussem.globaltestproject.domain.repository

import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.data.model.PrivatModel

interface Repository {
   suspend fun fetchData(): List<MonoModel>
}