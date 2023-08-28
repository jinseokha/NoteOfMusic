package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class GetAllMusicByCategoryUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute(start: Float, end: Float, genre: String) = musicRepository.getAllMusicByCategory(start, end, genre)
}