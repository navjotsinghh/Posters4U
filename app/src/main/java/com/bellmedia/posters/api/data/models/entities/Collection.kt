package com.bellmedia.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("aliases")
    val aliases: List<String>,
    @SerializedName("alternativeTitleLink")
    val alternativeTitleLink: Any?,
    @SerializedName("axisCollectionId")
    val axisCollectionId: Any?,
    @SerializedName("collectionType")
    val collectionType: String,
    @SerializedName("collectionTypeAttribute")
    val collectionTypeAttribute: CollectionTypeAttribute,
    @SerializedName("displayCollectionCount")
    val displayCollectionCount: Boolean,
    @SerializedName("displayRotatorTitle")
    val displayRotatorTitle: Boolean,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("itemCount")
    val itemCount: Int,
    @SerializedName("linearCollectionId")
    val linearCollectionId: Any?,
    @SerializedName("maxItems")
    val maxItems: Int,
    @SerializedName("mixedCollectionAlias")
    val mixedCollectionAlias: Any?,
    @SerializedName("promoTeaserMobileImageType")
    val promoTeaserMobileImageType: String?,
    @SerializedName("style")
    val style: String,
    @SerializedName("summary")
    val summary: Any?,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("upsellPackage")
    val upsellPackage: Any?,
    @SerializedName("videoStreams")
    val videoStreams: List<Any>
)