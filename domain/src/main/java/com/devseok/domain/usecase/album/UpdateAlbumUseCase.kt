package com.devseok.domain.usecase.album

import com.devseok.domain.repository.AlbumRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class UpdateAlbumUseCase @Inject constructor(private val albumRepository: AlbumRepository) {
    fun execute(id: Int, title: String, artist: String, genre: String, rating: Float, summary: String, content: String)
            = albumRepository.updateAlbum(id, title, artist, genre, rating, summary, content)
}