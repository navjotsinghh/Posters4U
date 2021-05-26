package com.jotbot.posters.api.data.models.entities

import com.google.gson.annotations.SerializedName

/**
 * Class for Error response
 *
 * Created by JotBot on 2021-05-18.
 */
data class Error(
        @SerializedName("protocol")
        val protocol: String,

        @SerializedName("code")
        val code: Int,

        @SerializedName("message")
        val message: String,

        @SerializedName("url")
        val url: String,
)
