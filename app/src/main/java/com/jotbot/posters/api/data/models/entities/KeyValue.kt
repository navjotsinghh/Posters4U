package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class KeyValue(
    @SerializedName("adTarget")
    val adTarget: Any?,
    @SerializedName("contentType")
    val contentType: Any?,
    @SerializedName("mediaType")
    val mediaType: Any?,
    @SerializedName("pageTitle")
    val pageTitle: String,
    @SerializedName("revShare")
    val revShare: Any?,
    @SerializedName("subType")
    val subType: String
)