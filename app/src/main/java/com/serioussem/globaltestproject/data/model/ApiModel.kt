package com.serioussem.globaltestproject.data.model

import com.google.gson.annotations.SerializedName

data class ApiModel(

	@field:SerializedName("ApiModel")
	val apiModel: List<ApiModelItem?>? = null
)

data class ApiModelItem(

	@field:SerializedName("sale")
	val sale: String? = null,

	@field:SerializedName("base_ccy")
	val baseCcy: String? = null,

	@field:SerializedName("buy")
	val buy: String? = null,

	@field:SerializedName("ccy")
	val ccy: String? = null
)
