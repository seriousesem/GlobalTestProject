package com.serioussem.globaltestproject.data.model

import com.google.gson.annotations.SerializedName

data class AnimeModel(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("success")
	val success: Boolean
)

data class DataItem(

	@field:SerializedName("anime_img")
	val animeImg: String,

	@field:SerializedName("anime_name")
	val animeName: String,

	@field:SerializedName("anime_id")
	val animeId: Int
)
