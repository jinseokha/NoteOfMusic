package com.devseok.data.repository.album.remote

import com.devseok.data.model.album.AlbumResponse
import kotlinx.coroutines.flow.Flow

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface AlbumRemoteDataSource {
    fun getRemoteAlbums(keyword: String): Flow<AlbumResponse>
}