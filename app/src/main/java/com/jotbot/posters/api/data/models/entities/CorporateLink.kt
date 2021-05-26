package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class CorporateLink(
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)