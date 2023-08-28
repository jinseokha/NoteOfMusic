package com.devseok.domain.model.album

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
@Parcelize
data class Album (
    var id : Int = 0,
    var image: String = "",
    var title: String = "",
    var artist: String = "",
    var genre: String = "",
    var trackList: String = "",
    var rating: Float = 0f,
    var summary: String = "",
    var content: String = "",
    var time: Long = System.currentTimeMillis()
): Parcelable
