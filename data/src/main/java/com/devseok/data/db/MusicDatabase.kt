package com.devseok.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devseok.data.model.album.AlbumEntity
import com.devseok.data.model.music.MusicEntity

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

@Database(entities = [MusicEntity::class, AlbumEntity::class], version = 1, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun MusicDao(): MusicDao
    abstract fun AlbumDao(): AlbumDao

}