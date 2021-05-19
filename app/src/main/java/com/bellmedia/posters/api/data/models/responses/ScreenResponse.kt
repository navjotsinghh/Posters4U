package com.bellmedia.posters.api.data.models.responses


import com.bellmedia.posters.api.data.models.entities.AdUnit
import com.bellmedia.posters.api.data.models.entities.Alias
import com.bellmedia.posters.api.data.models.entities.Collection
import com.google.gson.annotations.SerializedName

data class ScreenResponse(
    @SerializedName("adScreenType")
    val adScreenType: String,
    @SerializedName("adUnit")
    val adUnit: AdUnit,
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("collections")
    val collections: List<Collection>,
    @SerializedName("renderSecondaryNavTitleAs")
    val renderSecondaryNavTitleAs: String,
    @SerializedName("screenContentType")
    val screenContentType: String,
    @SerializedName("screenType")
    val screenType: String,
    @SerializedName("secondaryNavLinks")
    val secondaryNavLinks: List<Any>,
    @SerializedName("secondaryNavTitleImage")
    val secondaryNavTitleImage: Any?,
    @SerializedName("secondaryNavTitleText")
    val secondaryNavTitleText: Any?,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("error")
    val error: Throwable
):IResponse