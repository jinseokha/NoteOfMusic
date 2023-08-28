package com.devseok.data.repository.music.remote

import com.devseok.data.api.MusicApi
import com.devseok.data.model.music.MusicResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class MusicRemoteDataSourceImpl @Inject constructor(
    private val musicApi: MusicApi
): MusicRemoteDataSource {
    override fun getRemoteMusics(keyword: String): Flow<MusicResponse> = flow {
        emit(musicApi.getRemoteMusics(keyword))
    }
}