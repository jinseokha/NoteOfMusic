package com.devseok.data.repository.music.remote

import com.devseok.data.model.music.MusicResponse
import kotlinx.coroutines.flow.Flow

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface MusicRemoteDataSource {
    fun getRemoteMusics(keyword: String): Flow<MusicResponse>
}