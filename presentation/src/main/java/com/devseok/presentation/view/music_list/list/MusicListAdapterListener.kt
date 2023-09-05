package com.devseok.presentation.view.music_list.list

import com.devseok.domain.model.music.Music

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
interface MusicListAdapterListener {
    fun onItemClicked(music : Music)
    fun onOtherButtonClicked(music : Music)
}