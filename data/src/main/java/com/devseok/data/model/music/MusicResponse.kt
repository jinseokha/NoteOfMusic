package com.devseok.data.model.music

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

@Root(name = "rss", strict = false)
data class MusicResponse(
    @field:Element(name = "channel")
    var channle: Channel? = null
)

@Root(name = "channel", strict = false)
data class Channel @JvmOverloads constructor(
    @field:ElementList(inline = true, required = false)
    var itemList: List<Item>? = null
)

@Root(name = "item", strict = false)
data class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    var title: String = "",

    @field:Element(name = "album")
    var album: AlbumMusic? = null,

    @field:Element(name = "artist")
    var artist: Artist? = null
)

@Root(name = "album", strict = false)
data class AlbumMusic @JvmOverloads constructor(
    @field:Element(name = "image")
    var image: String = ""
)

@Root(name = "artist", strict = false)
data class Artist @JvmOverloads constructor(
    @field:Element(name = "name")
    var name: String = ""
)
