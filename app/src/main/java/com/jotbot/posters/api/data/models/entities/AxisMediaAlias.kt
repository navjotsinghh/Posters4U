package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class AxisMediaAlias(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("namespace")
    val namespace: String
)