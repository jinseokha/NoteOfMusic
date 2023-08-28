package com.devseok.data.mapper

import com.devseok.data.model.music.MusicEntity
import com.devseok.data.model.music.MusicResponse
import com.devseok.domain.model.music.DomainMusicResponse
import com.devseok.domain.model.music.Music

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

// Domain -> Data (id, time 은 자동 생성, 받지 않는다.)
fun mapperToMusicEntity(music: Music): MusicEntity {
    return MusicEntity(
        image = music.image,
        title = music.title,
        artist = music.artist,
        genre = music.genre,
        rating = music.rating,
        summary = music.summary,
        content = music.content
    )
}

// Data -> Domain
fun mapperToMusic(musics: List<MusicEntity>): List<Music> {
    return musics.toList().map {
        Music(
            id = it.id,
            image = it.image,
            title = it.title,
            artist = it.artist,
            genre = it.genre,
            rating = it.rating,
            summary = it.summary,
            content = it.content,
            time = it.time
        )
    }
}

// Data -> Domain
fun mapperToMusicResponse(musicResponses: MusicResponse): List<DomainMusicResponse> {
    return musicResponses.channle!!.itemList!!.map {
        val title = it.title.replace("&nbsp;", " ").replace("&amp;", "&")
            DomainMusicResponse(
                title = title,
                artist = it.artist!!.name,
                image = it.album!!.image
            )
    }
}