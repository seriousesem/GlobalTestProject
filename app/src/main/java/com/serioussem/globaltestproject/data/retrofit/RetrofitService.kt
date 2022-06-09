package com.serioussem.globaltestproject.data.retrofit

import com.serioussem.globaltestproject.data.model.ApiModel
import retrofit2.http.GET

interface RetrofitService {

    @GET("pubinfo?json&exchange&coursid=5")
    suspend fun fetchData(): ApiModel
}
