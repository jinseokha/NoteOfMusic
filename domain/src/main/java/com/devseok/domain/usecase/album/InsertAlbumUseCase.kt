package com.devseok.domain.usecase.album

import com.devseok.domain.model.album.Album
import com.devseok.domain.repository.AlbumRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class InsertAlbumUseCase @Inject constructor(private val albumRepository: AlbumRepository) {
    fun execute(album: Album) = albumRepository.insertAlbum(album)
}