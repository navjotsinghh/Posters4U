package com.bellmedia.posters

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.LiveData

/**
 *
 * LiveData for network callbacks
 *
 * Created by JotBot on 2021-05-16.
 */
class NetworkLiveData(context: Context) : LiveData<Boolean>() {

    private val _tag = NetworkLiveData::class.java.simpleName

    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    private val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    private var validNetworks: MutableSet<Network> = HashSet()

    override fun onActive() {
        super.onActive()
        networkCallback = createNetworkCallback()
        val networkRequest = NetworkRequest.Builder()
                .addCapability(NET_CAPABILITY_INTERNET)
                .build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    /**
     * Check valid networks
     */
    fun checkValidNetworks() {
        postValue(validNetworks.size > 0)
    }

    /**
     * Create network callback to listen to changes in network
     */
    private fun createNetworkCallback(): ConnectivityManager.NetworkCallback =
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    Log.d(_tag, "onAvailable $network")
                    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
                    val isInternet = networkCapabilities?.hasCapability(NET_CAPABILITY_INTERNET)
                    Log.d(_tag, "onAvailable $network $isInternet")

                    if (isInternet == true) {
                        validNetworks.add(network)
                    }
                    checkValidNetworks()
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    Log.d(_tag, "onLost $network")

                    validNetworks.remove(network)
                    checkValidNetworks()

                }
            }
}