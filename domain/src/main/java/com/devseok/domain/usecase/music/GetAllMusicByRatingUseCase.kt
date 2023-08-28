package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class GetAllMusicByRatingUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute(start: Float, end: Float) = musicRepository.getAllMusicByRating(start, end)
}