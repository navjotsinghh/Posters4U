package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class AdUnit(
    @SerializedName("adultAudience")
    val adultAudience: Boolean,
    @SerializedName("heroBrand")
    val heroBrand: String,
    @SerializedName("keyValue")
    val keyValue: KeyValue,
    @SerializedName("pageType")
    val pageType: String,
    @SerializedName("product")
    val product: String,
    @SerializedName("revShare")
    val revShare: Any?,
    @SerializedName("title")
    val title: Any?,
    @SerializedName("type")
    val type: String
)