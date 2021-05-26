package com.jotbot.posters.api.services

import com.jotbot.posters.api.data.models.responses.MobileResponse
import com.jotbot.posters.api.data.models.responses.PostersResponse
import com.jotbot.posters.api.data.models.responses.ScreenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * Interface for API endpoints to fetch posters
 *
 * Created by JotBot on 2021-05-15.
 */
interface PostersAPI {

    @GET("apps/mobile")
    suspend fun fetchMobile(): Response<MobileResponse>


    @GET("apps/screen/{namespace}/{alias}")
    suspend fun fetchScreens(
        @Path("namespace") namespace: String,
        @Path("alias") alias: String
    ): Response<ScreenResponse>


    @GET("collection/{namespace}/{alias}")
    suspend fun fetchPosters(
        @Path("namespace") namespace: String,
        @Path("alias") alias: String
    ): Response<PostersResponse>
}