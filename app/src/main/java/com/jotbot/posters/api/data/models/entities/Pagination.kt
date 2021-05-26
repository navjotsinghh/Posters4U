package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("alias")
    val alias: Any?,
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("dataType")
    val dataType: String,
    @SerializedName("facets")
    val facets: List<Any>,
    @SerializedName("nextPage")
    val nextPage: Boolean,
    @SerializedName("previousPage")
    val previousPage: Boolean,
    @SerializedName("size")
    val size: Int,
    @SerializedName("totalNumFound")
    val totalNumFound: Int,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("type")
    val type: String
)