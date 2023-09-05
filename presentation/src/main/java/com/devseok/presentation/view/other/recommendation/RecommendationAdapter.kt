package com.devseok.presentation.view.other.recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devseok.domain.model.other.RecommendationResponse
import com.devseok.presentation.databinding.ItemRecommendationBinding

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
class RecommendationAdapter(private val listener: RecommendationAdapterListener) : ListAdapter<RecommendationResponse, RecommendationAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemRecommendationBinding):
        RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener.onItemClicked(getItem(adapterPosition))
            }
        }
        fun bind(recommendation: RecommendationResponse){
            binding.recommendation = recommendation
        }
    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<RecommendationResponse>(){
            override fun areItemsTheSame(oldItem: RecommendationResponse, newItem: RecommendationResponse): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: RecommendationResponse, newItem: RecommendationResponse): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}