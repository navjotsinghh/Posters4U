package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class Alias(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("namespace")
    val namespace: String
)