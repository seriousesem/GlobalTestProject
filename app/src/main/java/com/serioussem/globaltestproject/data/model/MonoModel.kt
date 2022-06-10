package com.serioussem.globaltestproject.data.model

import com.google.gson.annotations.SerializedName

data class MonoModel(

	@field:SerializedName("MonoModel")
	val monoModel: List<MonoModelItem>
)

data class MonoModelItem(

	@field:SerializedName("date")
	val date: Int,

	@field:SerializedName("currencyCodeA")
	val currencyCodeA: Int,

	@field:SerializedName("currencyCodeB")
	val currencyCodeB: Int,

	@field:SerializedName("rateCross")
	val rateCross: Double,

	@field:SerializedName("rateBuy")
	val rateBuy: Double,

	@field:SerializedName("rateSell")
	val rateSell: Double
)
