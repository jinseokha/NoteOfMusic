package com.devseok.presentation.view.album_list.search

import com.devseok.domain.model.album.DomainAlbumResponse

interface AlbumSearchAdapterListener {
    fun onItemClicked(albumInfo : DomainAlbumResponse)
}