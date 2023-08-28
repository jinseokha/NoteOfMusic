package com.devseok.domain.model.album

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
@Parcelize
data class DomainAlbumResponse(
    val title: String = "",
    val artist: String = "",
    val image: String = "",
    val trackList: String = ""
): Parcelable
