package com.devseok.domain.usecase.music

import com.devseok.domain.model.music.Music
import com.devseok.domain.repository.MusicRepository
import javax.inject.Inject

class InsertMusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    fun execute(music: Music) = musicRepository.insertMusic(music)
}