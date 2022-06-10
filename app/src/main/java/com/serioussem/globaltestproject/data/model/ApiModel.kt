package com.serioussem.globaltestproject.data.model

import com.google.gson.annotations.SerializedName

data class ApiModel(

	@field:SerializedName("ApiModel")
	val apiModel: List<ApiModelItem?>
)

data class ApiModelItem(

	@field:SerializedName("sale")
	val sale: String,

	@field:SerializedName("base_ccy")
	val baseCcy: String,

	@field:SerializedName("buy")
	val buy: String,

	@field:SerializedName("ccy")
	val ccy: String
)
