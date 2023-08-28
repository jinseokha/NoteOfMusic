package com.devseok.domain.usecase.music

import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class GetRemoteMusicsUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute(keyword: String) = musicRepository.getRemoteMusics(keyword)
}