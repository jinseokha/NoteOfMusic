package com.devseok.domain.usecase.album

import com.devseok.domain.repository.AlbumRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class GetAllAlbumByRatingUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) {
    fun execute(start: Float, end: Float) = albumRepository.getAllAlbumByRating(start, end)
}