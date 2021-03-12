package com.example.trapeziumcards

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trapeziumcards.databinding.ItemBinding


class PopularListAdapter(private val clickListener: PopularListClickListener) :
    ListAdapter<Result, PopularListAdapter.MovieListViewHolder>(Companion) {

    private var lastPosition = -1
    private var context: Context? = null

    inner class MovieListViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val currentUser = getItem(position)
        holder.binding.executePendingBindings()
        // Set the view to fade in
//        setFadeAnimation(holder.itemView);
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1
        view.startAnimation(anim)
    }

    class PopularListClickListener(val clickListener: (mMovieId: String) -> Unit) {
        fun onClick(mMovieId: String) = clickListener(mMovieId)
    }

    private fun setFadeAnimation(view: View, position: Int) {
        val anim = if (position > lastPosition) R.anim.rotate_amin else R.anim.rotate_exit
        val rotate = AnimationUtils.loadAnimation(context, anim)
        view.startAnimation(rotate)
        lastPosition = position - 1
    }

    override fun onViewDetachedFromWindow(holder: MovieListViewHolder) {
//        holder.itemView.clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }


    override fun onViewAttachedToWindow(holder: MovieListViewHolder) {
//        setFadeAnimation(holder.itemView, holder.layoutPosition)
        super.onViewAttachedToWindow(holder)
    }
}