package com.devseok.presentation.view.album_list.list

import com.devseok.domain.model.album.Album

interface AlbumListAdapterListener {
    fun onItemClicked(album : Album)
    fun onOtherButtonClicked(album : Album)
}