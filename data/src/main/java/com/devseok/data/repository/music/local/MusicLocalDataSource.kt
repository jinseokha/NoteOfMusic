package com.devseok.data.repository.music.local

import com.devseok.data.model.music.MusicEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface MusicLocalDataSource {
    fun insertMusic(music : MusicEntity)
    fun getAllMusic(): Flow<List<MusicEntity>>
    fun deleteMusic(id : Int)
    fun updateMusic(id: Int, title: String, artist: String, genre: String, rating: Float, summary: String, content: String)
    fun getAllMusicByRating(start: Float, end: Float): Flow<List<MusicEntity>>
    fun getAllMusicByCategory(start: Float, end: Float, genre: String): Flow<List<MusicEntity>>
    fun getAllMusicCount(): Flow<Int>
    fun deleteAllMusic()
}