package com.bellmedia.posters.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bellmedia.posters.BaseApplication
import com.bellmedia.posters.api.data.models.entities.Content
import com.bellmedia.posters.api.data.models.entities.LoadingState
import com.bellmedia.posters.api.data.repo.PostersRepo
import kotlinx.coroutines.launch

/**
 * ViewModel for PostersFragment
 *
 * Created by JotBot on 2021-05-16.
 */
class PostersFragmentViewModel : ViewModel() {

    /**
     * MutableLiveData list of Posters
     */
    private var _posters = MutableLiveData<List<Content>>()

    /**
     * List of Posters observed in view
     */
    val posters: LiveData<List<Content>>
        get() = _posters

    /**
     * MutableLiveData for state of API call
     */
    private val _loading = MutableLiveData<LoadingState>()

    /**
     * State of API call observed in view
     */
    val loading: LiveData<LoadingState>
        get() = _loading


    /**
     * Get posters from network
     */
    fun fetchPosters() {
        viewModelScope.launch {
            try {
                _loading.postValue(LoadingState.LOADING)
                PostersRepo.fetchMobile().let { mobileResponse ->
                    if (mobileResponse.isSuccessful) {

                        // First call
                        val screens = mobileResponse.body()?.screens

                        if (screens != null) {
                            for (screen in screens) {
                                if (screen.title.equals("kids", true)
                                        &&
                                        screen.screenType.equals("home", true)
                                ) {
                                    val namespace = screen.alias.namespace
                                    val alias = screen.alias.alias

                                    // Second call
                                    val screenResponse =
                                        PostersRepo.fetchScreens(namespace, alias)
                                    if (screenResponse.isSuccessful) {


                                        val collectionList = screenResponse.body()?.collections
                                        if (collectionList != null) {
                                            for (collection in collectionList) {
                                                if (collection.style.equals("posters", true)) {

                                                    // Third call
                                                    val posterResponse = PostersRepo.fetchPosters(
                                                            collection.alias.namespace,
                                                            collection.alias.alias
                                                    )
                                                    if (posterResponse.isSuccessful) {
                                                        posterResponse.body()?.content.let { response ->
                                                            _loading.postValue(LoadingState.LOADED)
                                                            _posters.postValue(response)
                                                        }
                                                    } else {
                                                        _loading.postValue(LoadingState.error(posterResponse.message()))
                                                    }
                                                    break
                                                }

                                            }
                                        }
                                    } else {
                                        _loading.postValue(LoadingState.error(screenResponse.message()))
                                    }
                                }
                            }
                        }
                    } else {
                        _loading.postValue(LoadingState.error(mobileResponse.message()))
                    }
                }
            } catch (e: Exception) {
                if (BaseApplication.instance.hasNetwork) {
                    _loading.postValue(LoadingState.error(e.message))
                } else {
                    _loading.postValue(LoadingState.NETWORK_ERROR)
                }
            }
        }
    }
}