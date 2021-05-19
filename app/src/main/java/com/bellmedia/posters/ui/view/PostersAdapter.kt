package com.bellmedia.posters.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bellmedia.posters.api.data.models.entities.Content
import com.bellmedia.posters.databinding.PosterItemBinding
import com.bellmedia.posters.ui.view.PostersAdapter.ViewHolder

/**
 * Adapter for recyclerView to show the list of posters
 *
 * Created by JotBot on 2021-05-16.
 */
class PostersAdapter(
    val posters: List<Content>,
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PosterItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(posters[position])
    }

    override fun getItemCount(): Int = posters.size

    /**
     * View holder
     */
    inner class ViewHolder(private val binding: PosterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(poster: Content) {
            binding.poster = poster
            binding.executePendingBindings()
        }
    }
}