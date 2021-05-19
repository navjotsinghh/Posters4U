package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class MetadataUpgrade(
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("packageName")
    val packageName: String,
    @SerializedName("subText")
    val subText: Any?,
    @SerializedName("userIsSubscribed")
    val userIsSubscribed: Boolean
)