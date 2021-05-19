package com.bellmedia.posters.api.data.models.responses


import com.bellmedia.posters.api.data.models.entities.Alias
import com.bellmedia.posters.api.data.models.entities.CollectionTypeAttribute
import com.bellmedia.posters.api.data.models.entities.Content
import com.bellmedia.posters.api.data.models.entities.Pagination
import com.google.gson.annotations.SerializedName

data class PostersResponse(
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("aliases")
    val aliases: List<String>,
    @SerializedName("alternativeTitleLink")
    val alternativeTitleLink: Any?,
    @SerializedName("axisCollectionId")
    val axisCollectionId: Int,
    @SerializedName("collectionType")
    val collectionType: String,
    @SerializedName("collectionTypeAttribute")
    val collectionTypeAttribute: CollectionTypeAttribute,
    @SerializedName("content")
    val content: List<Content>,
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
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("promoTeaserMobileImageType")
    val promoTeaserMobileImageType: Any?,
    @SerializedName("style")
    val style: String,
    @SerializedName("summary")
    val summary: Any?,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("upsellButtonCopy")
    val upsellButtonCopy: Any?,
    @SerializedName("upsellLogo")
    val upsellLogo: Any?,
    @SerializedName("upsellPackage")
    val upsellPackage: Any?,
    @SerializedName("upsellSummary")
    val upsellSummary: Any?,
    @SerializedName("videoStreams")
    val videoStreams: List<Any>,
    @SerializedName("error")
    val error: Throwable
):IResponse