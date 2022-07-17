package com.serioussem.globaltestproject.data.repository

import com.serioussem.globaltestproject.data.jsoup.JsoupService
import com.serioussem.globaltestproject.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: JsoupService) : Repository {
    override suspend fun loadData(): String =
        try {
            service.connectToSite()
        }catch (e: Exception){
            e.message.toString()
        }
}