package com.jotbot.posters.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jotbot.posters.BaseApplication
import com.jotbot.posters.NetworkLiveData
import com.jotbot.posters.R
import com.jotbot.posters.api.data.models.entities.LoadingState
import com.jotbot.posters.databinding.FragmentPostersBinding
import com.jotbot.posters.ui.viewmodel.PostersFragmentViewModel
import com.google.android.material.snackbar.Snackbar


/**
 * A simple [Fragment] subclass to show the list of Posters
 */
class PostersFragment : Fragment() {

    private lateinit var binding: FragmentPostersBinding
    private lateinit var postersFragmentViewModel: PostersFragmentViewModel
    private lateinit var networkLiveData: NetworkLiveData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_posters, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSwipeRefreshLayoutListener()

        initViewModel()

        // Fetch posters
        fetchPosters()

        // Observer to posters
        postersFragmentViewModel.posters.observe({ lifecycle }) {
            // Hide progress bar
            setProgressBarVisibility(false)
            // Show posters list in recyclerview
            binding.recyclerView.adapter = PostersAdapter(it)
        }

        postersFragmentViewModel.loading.observe({ lifecycle }) {
            when (it) {
                LoadingState.LOADING -> setProgressBarVisibility(true)
                LoadingState.LOADED -> setProgressBarVisibility(false)
                LoadingState.NETWORK_ERROR -> {
                    setProgressBarVisibility(false)
                    showErrorMessage(getString(R.string.no_network_message))
                }
                LoadingState.error(it.msg) -> {
                    setProgressBarVisibility(false)
                    showErrorMessage(it.msg.toString())
                }
            }
        }

        // Observe to network callbacks
        networkLiveData.observe({ lifecycle }) {

            when (it) {
                true -> {
                    if (!BaseApplication.instance.hasNetwork) {
                        fetchPosters()
                        showErrorMessage(getString(R.string.internet_available_message))
                    }

                }
                false -> {
                    showErrorMessage(getString(R.string.internet_lost_message))
                }
            }
            BaseApplication.instance.hasNetwork = it
        }
    }

    /**
     * Swipe refresh layout listener
     */
    private fun setSwipeRefreshLayoutListener() {
        binding.swipeRefresh.apply {
            // Refresh listener
            setOnRefreshListener {
                if (BaseApplication.instance.hasNetwork) {
                    // Fetch posters
                    fetchPosters()
                } else {
                    showErrorMessage(getString(R.string.no_network_message))
                }

                isRefreshing = false
            }
            // Color for refresh spinner
            setColorSchemeColors(
                resources.getColor(
                    R.color.design_default_color_primary,
                    null
                ),
                resources.getColor(
                    R.color.design_default_color_primary_dark,
                    null
                )
            )
        }
    }

    /**
     * Show error message in a SnackBar
     */
    private fun showErrorMessage(message: String) {
        Snackbar.make(
            binding.swipeRefresh,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    /**
     * Initialize view model @MainActivityViewModel
     */
    private fun initViewModel() {
        postersFragmentViewModel = ViewModelProvider(this).get(PostersFragmentViewModel::class.java)
        networkLiveData = NetworkLiveData(requireContext())
    }

    /**
     * Show/hide progress bar
     */
    private fun setProgressBarVisibility(isVisibility: Boolean) {
        when (isVisibility) {
            true -> binding.postersProgressBar.visibility = View.VISIBLE
            false -> binding.postersProgressBar.visibility = View.GONE
        }
    }

    /**
     * Fetch the list of posters
     */
    private fun fetchPosters() {
        postersFragmentViewModel.fetchPosters()
    }

}