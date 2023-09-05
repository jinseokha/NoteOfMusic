package com.devseok.presentation.view.music_list.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devseok.domain.model.music.DomainMusicResponse
import com.devseok.presentation.databinding.ItemMusicSearchBinding

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
class MusicSearchAdapter(private val listener: MusicSearchAdapterListener) : ListAdapter<DomainMusicResponse, MusicSearchAdapter.ViewHolder>(
    diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMusicSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMusicSearchBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener.onItemClicked(getItem(adapterPosition))
            }
        }
        fun bind(musicInfo: DomainMusicResponse){
            binding.musicInfo = musicInfo
        }
    }
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DomainMusicResponse>(){
            override fun areItemsTheSame(oldItem: DomainMusicResponse, newItem: DomainMusicResponse): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: DomainMusicResponse, newItem: DomainMusicResponse): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }

}