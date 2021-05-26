package com.jotbot.posters

import android.app.Application
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET

/**
 * Base application class
 *
 * Created by JotBot on 2021-05-16.
 */
class BaseApplication : Application() {
    var hasNetwork: Boolean = false

    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        hasNetwork = isNetworkConnected()
    }

    /**
     * Check is internet connected
     */
    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)
        return networkCapabilities?.hasCapability(NET_CAPABILITY_INTERNET) == true
    }

}