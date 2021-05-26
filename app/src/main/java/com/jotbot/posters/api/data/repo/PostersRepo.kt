package com.jotbot.posters.api.data.repo

import com.jotbot.posters.api.PostersClient

/**
 *
 * Repository object for fetching posters
 *
 * Created by JotBot on 2021-05-19.
 */
object PostersRepo {
    private val api = PostersClient().api

    suspend fun fetchMobile() = api.fetchMobile()

    suspend fun fetchPosters(namespace: String, alias: String) = api.fetchPosters(namespace, alias)

    suspend fun fetchScreens(namespace: String, alias: String) = api.fetchScreens(namespace, alias)
}