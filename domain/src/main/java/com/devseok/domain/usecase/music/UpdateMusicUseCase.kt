package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class UpdateMusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute(id: Int, title: String, artist: String, genre: String, rating: Float, summary: String, content: String)
        = musicRepository.updateMusic(id, title, artist, genre, rating, summary, content)
}