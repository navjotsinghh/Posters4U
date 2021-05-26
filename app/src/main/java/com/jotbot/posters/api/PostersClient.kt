package com.jotbot.posters.api

import com.jotbot.posters.BaseApplication
import com.jotbot.posters.api.services.PostersAPI
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit client
 */
class PostersClient {

    private val _baseUrl = "https://raacestg.entpay.9c9media.ca/mobile/v2/"

    /**
     * Duration of 7 days
     */
    private val _duration = 60 * 60 * 24 * 7

    /**
     * Size of cache
     */
    private val cacheSize = (5 * 1024 * 1024).toLong()

    private val postersCache = Cache(BaseApplication.instance.cacheDir, cacheSize)

    private val okHttpClient = OkHttpClient.Builder()
            .cache(postersCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (BaseApplication.instance.hasNetwork)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header(
                            "Cache-Control",
                            "public, only-if-cached, max-stale=$_duration"
                    ).build()
                chain.proceed(request)
            }
            .build()



    /**
     * Build a new retrofit instance
     */
    private val retrofit = Retrofit.Builder()
            .baseUrl(_baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    val api: PostersAPI = retrofit.create(PostersAPI::class.java)
}