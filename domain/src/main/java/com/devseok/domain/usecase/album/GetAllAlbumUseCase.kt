package com.devseok.domain.usecase.album

import com.devseok.domain.repository.AlbumRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class GetAllAlbumUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) {
    fun execute() = albumRepository.getAllAlbum()
}