package com.devseok.data.repository.music.local

import com.devseok.data.db.MusicDao
import com.devseok.data.model.music.MusicEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class MusicLocalDataSourceImpl @Inject constructor(private val musicDao: MusicDao)
    : MusicLocalDataSource {

    override fun insertMusic(music: MusicEntity) = musicDao.insertMusic(music)

    override fun getAllMusic(): Flow<List<MusicEntity>> = musicDao.getAllMusic()

    override fun deleteMusic(id: Int) = musicDao.deleteMusic(id)

    override fun updateMusic(
        id: Int,
        title: String,
        artist: String,
        genre: String,
        rating: Float,
        summary: String,
        content: String
    ) = musicDao.updateMusic(id, title, artist, genre, rating, summary, content)

    override fun getAllMusicByRating(start: Float, end: Float): Flow<List<MusicEntity>>
            = musicDao.getAllMusicByRating(start, end)

    override fun getAllMusicByCategory(
        start: Float,
        end: Float,
        genre: String
    ): Flow<List<MusicEntity>> = musicDao.getAllMusicByCategory(start, end, genre)

    override fun getAllMusicCount(): Flow<Int> = musicDao.getAllMusicCount()

    override fun deleteAllMusic() = musicDao.deleteAllMusic()
}