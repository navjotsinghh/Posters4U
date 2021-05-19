package com.bellmedia.posters.api.data.models.responses


import com.bellmedia.posters.api.data.models.entities.Alias
import com.bellmedia.posters.api.data.models.entities.CorporateLink
import com.bellmedia.posters.api.data.models.entities.NavigationLink
import com.bellmedia.posters.api.data.models.entities.Screen
import com.google.gson.annotations.SerializedName
import com.bellmedia.posters.api.data.models.entities.Error

data class MobileResponse(
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("appType")
    val appType: String,
    @SerializedName("corporateLinks")
    val corporateLinks: List<CorporateLink>,
    @SerializedName("dfpIUNumber")
    val dfpIUNumber: Int,
    @SerializedName("kidsAllowedScreens")
    val kidsAllowedScreens: List<Any>,
    @SerializedName("navigationLinks")
    val navigationLinks: List<NavigationLink>,
    @SerializedName("screens")
    val screens: List<Screen>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("error")
    val error: Throwable
):IResponse