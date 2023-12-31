package com.devseok.data.mapper

import com.devseok.data.model.album.AlbumEntity
import com.devseok.data.model.album.AlbumResponse
import com.devseok.domain.model.album.Album
import com.devseok.domain.model.album.DomainAlbumResponse

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

// Domain -> Data (id, time 은 자동 생성, 받지 않는다.)
fun mapperToAlbumEntity(album: Album): AlbumEntity {
    return AlbumEntity (
        image = album.image,
        title = album.title,
        artist = album.artist,
        genre = album.genre,
        trackList = album.trackList,
        rating = album.rating,
        summary = album.summary,
        content = album.content
    )
}

// Data -> Domain
fun mapperToAlbum(albums: List<AlbumEntity>): List<Album> {
    return albums.toList().map {
        Album (
            id = it.id,
            image = it.image,
            title = it.title,
            artist = it.artist,
            genre = it.genre,
            trackList = it.trackList,
            rating = it.rating,
            summary = it.summary,
            content = it.content,
            time = it.time
        )
    }
}

// Data -> Domain
fun mapperToAlbumResponse(albumResponse: AlbumResponse): List<DomainAlbumResponse> {
    return albumResponse.channel!!.itemList!!.map {
        val title = it.title.replace("&nbsp;", " ").replace("&amp;", "&")
        val trackList = it.album!!.trackList.replace("&nbsp;"," ")
            .replace("&amp;","&").replace("/", "\n")
            .replace("[Disc 1]\n1.","[Disc 1]\n 1.")
            .replace("[Disc 2]\n1.","[Disc 2]\n 1.")
        DomainAlbumResponse(
            title = title,
            artist = it.artist.toString(),
            image = it.image,
            trackList = trackList
        )
    }
}


