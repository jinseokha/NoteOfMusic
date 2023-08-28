package com.devseok.data.repository.album.remote

import com.devseok.data.api.MusicApi
import com.devseok.data.model.album.AlbumResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class AlbumRemoteDataSourceImpl @Inject constructor(
    private val musicApi: MusicApi
) : AlbumRemoteDataSource {

    override fun getRemoteAlbums(keyword: String): Flow<AlbumResponse>
    = flow {
        emit(musicApi.getRemoteAlbums(keyword))
    }
}