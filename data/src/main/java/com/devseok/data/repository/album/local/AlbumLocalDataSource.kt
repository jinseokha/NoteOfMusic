package com.devseok.data.repository.album.local

import com.devseok.data.model.album.AlbumEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface AlbumLocalDataSource {
    fun insertAlbum(album : AlbumEntity)
    fun getAllAlbum(): Flow<List<AlbumEntity>>
    fun deleteAlbum(id : Int)
    fun updateAlbum(id: Int, title: String, artist: String, genre: String, rating: Float, summary: String, content: String)
    fun getAllAlbumByRating(start: Float, end: Float): Flow<List<AlbumEntity>>
    fun getAllAlbumByCategory(start: Float, end: Float, genre: String): Flow<List<AlbumEntity>>
    fun getAllAlbumCount(): Flow<Int>
    fun deleteAllAlbum()
}