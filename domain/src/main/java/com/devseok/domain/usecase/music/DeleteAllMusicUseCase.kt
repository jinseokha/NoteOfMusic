package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class DeleteAllMusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute() = musicRepository.deleteAllMusic()
}