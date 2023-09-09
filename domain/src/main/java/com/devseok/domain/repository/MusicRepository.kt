package com.devseok.domain.repository

import com.devseok.domain.model.music.DomainMusicResponse
import com.devseok.domain.model.music.Music
import com.devseok.domain.utils.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface MusicRepository {
    fun insertMusic(music : Music)
    fun getAllMusic(): Flow<Result<List<Music>>>
    fun getRemoteMusics(keyword: String): Flow<Result<List<DomainMusicResponse>>>
    fun deleteMusic(id : Int)
    fun updateMusic(id: Int, title: String, artist: String, genre: String, rating: Float, summary: String, content: String)
    fun getAllMusicByRating(start: Float, end: Float): Flow<Result<List<Music>>>
    fun getAllMusicByCategory(start: Float, end: Float, genre: String): Flow<Result<List<Music>>>
    fun getAllMusicCount(): Flow<Result<Int>>
    fun deleteAllMusic()
}