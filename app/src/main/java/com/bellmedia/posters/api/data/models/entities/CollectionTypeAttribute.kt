package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class CollectionTypeAttribute(
    @SerializedName("genres")
    val genres: List<Any>,
    @SerializedName("keywords")
    val keywords: List<Any>,
    @SerializedName("mediaTypes")
    val mediaTypes: List<Any>
)