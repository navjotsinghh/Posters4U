package com.jotbot.posters.api.data.models.entities


import com.google.gson.annotations.SerializedName

data class NavigationLink(
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("buttonStyle")
    val buttonStyle: Any?,
    @SerializedName("filterParameter")
    val filterParameter: Any?,
    @SerializedName("filterParameters")
    val filterParameters: FilterParameters,
    @SerializedName("imageLink")
    val imageLink: Any?,
    @SerializedName("images")
    val images: List<Any>,
    @SerializedName("internalContent")
    val internalContent: InternalContent,
    @SerializedName("linkType")
    val linkType: String,
    @SerializedName("renderAs")
    val renderAs: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: Any?,
    @SerializedName("videoStreams")
    val videoStreams: List<Any>
)