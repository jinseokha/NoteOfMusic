package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class GetAllMusicCountUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute() = musicRepository.getAllMusicCount()
}