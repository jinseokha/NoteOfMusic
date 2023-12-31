package com.devseok.data.repository.album.local

import com.devseok.data.db.AlbumDao
import com.devseok.data.model.album.AlbumEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class AlbumLocalDataSourceImpl @Inject constructor(private val albumDao: AlbumDao)
    : AlbumLocalDataSource {
    override fun insertAlbum(album: AlbumEntity) = albumDao.insertAlbum(album)

    override fun getAllAlbum(): Flow<List<AlbumEntity>> = albumDao.getAllAlbum()

    override fun deleteAlbum(id: Int) = albumDao.deleteAlbum(id)

    override fun updateAlbum(
        id: Int,
        title: String,
        artist: String,
        genre: String,
        rating: Float,
        summary: String,
        content: String
    ) = albumDao.updateAlbum(id, title, artist, genre, rating, summary, content)

    override fun getAllAlbumByRating(start: Float, end: Float): Flow<List<AlbumEntity>>
            = albumDao.getAllAlbumByRating(start, end)

    override fun getAllAlbumByCategory(
        start: Float,
        end: Float,
        genre: String
    ): Flow<List<AlbumEntity>>
            = albumDao.getAllAlbumByCategory(start, end, genre)

    override fun getAllAlbumCount(): Flow<Int>
            = albumDao.getAllAlbumCount()

    override fun deleteAllAlbum()
            = albumDao.deleteAllAlbum()
}