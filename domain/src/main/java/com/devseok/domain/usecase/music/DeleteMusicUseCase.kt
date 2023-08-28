package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class DeleteMusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute(id : Int) = musicRepository.deleteMusic(id)
}