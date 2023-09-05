package com.devseok.presentation.view.music_list.search

import com.devseok.domain.model.music.DomainMusicResponse

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
interface MusicSearchAdapterListener {
    fun onItemClicked(musicInfo : DomainMusicResponse)
}