package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class InternalContent(
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("screenContentType")
    val screenContentType: String,
    @SerializedName("screenType")
    val screenType: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)