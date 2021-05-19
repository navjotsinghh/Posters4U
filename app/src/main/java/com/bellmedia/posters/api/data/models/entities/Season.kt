package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("axisId")
    val axisId: Int,
    @SerializedName("axisMediaAlias")
    val axisMediaAlias: AxisMediaAlias,
    @SerializedName("defaultLangCode")
    val defaultLangCode: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("metadataUpgrade")
    val metadataUpgrade: List<MetadataUpgrade>,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("resourceCodes")
    val resourceCodes: List<String>,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("subscriptionPackages")
    val subscriptionPackages: List<String>,
    @SerializedName("type")
    val type: String
)