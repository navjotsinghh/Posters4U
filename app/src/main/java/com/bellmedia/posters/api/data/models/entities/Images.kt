package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("bg tall")
    val bgTall: List<String>,
    @SerializedName("bg wide")
    val bgWide: List<String>,
    @SerializedName("clr logo")
    val clrLogo: List<String>,
    @SerializedName("clr logo 2")
    val clrLogo2: List<String>,
    @SerializedName("cover")
    val cover: List<String>,
    @SerializedName("poster")
    val poster: List<String>,
    @SerializedName("pr-tser")
    val prTser: List<String>,
    @SerializedName("pr-tser-sm")
    val prTserSm: List<String>,
    @SerializedName("square")
    val square: List<String>,
    @SerializedName("thumbnail")
    val thumbnail: List<String>
)