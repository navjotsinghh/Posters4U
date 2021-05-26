package com.jotbot.posters.api.data.models.entities

/**
 * Created by JotBot on 2021-05-18.
 */
@Suppress("DataClassPrivateConstructor")
data class LoadingState private constructor(val status: Status, val msg: String? = null) {
    companion object {
        val LOADED = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)
        val NETWORK_ERROR = LoadingState(Status.FAILED)
        fun error(msg: String?) = LoadingState(Status.FAILED, msg)

    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}
