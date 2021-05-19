package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class OriginatingNetworkImages(
    @SerializedName("logo")
    val logo: List<String>
)