package com.devseok.data.api

import com.devseok.data.model.album.AlbumResponse
import com.devseok.data.model.music.MusicResponse
import com.devseok.data.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path

interface MusicApi {
    @GET("{keyword}/?sr=song&display=15&key=$API_KEY&v=0.5")
    suspend fun getRemoteMusics(@Path("keyword") keyword: String) : MusicResponse

    @GET("{keyword}/?sr=album&display=15&key=$API_KEY&v=0.5")
    suspend fun getRemoteAlbums(@Path("keyword") keyword: String) : AlbumResponse
}