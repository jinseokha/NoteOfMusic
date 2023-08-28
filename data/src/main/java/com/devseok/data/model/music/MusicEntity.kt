package com.devseok.data.model.music

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
@Entity(tableName = "music_table")
data class MusicEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var image: String = "",
    var title: String = "",
    var artist: String = "",
    var genre: String = "",
    var rating: Float = 0f,
    var summary: String = "",
    var content: String = "",
    var time: Long = System.currentTimeMillis()
)
