package com.devseok.noteofmusic.di

import android.content.Context
import androidx.room.Room
import com.devseok.data.db.AlbumDao
import com.devseok.data.db.MusicDao
import com.devseok.data.db.MusicDatabase
import com.devseok.data.repository.album.local.AlbumLocalDataSource
import com.devseok.data.repository.album.local.AlbumLocalDataSourceImpl
import com.devseok.data.repository.music.local.MusicLocalDataSource
import com.devseok.data.repository.music.local.MusicLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Ha Jin Seok
 * @created 2023-09-06
 * @desc
 */

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    // Database(Room) DI
    @Singleton
    @Provides
    fun provideMusicDatabase(@ApplicationContext context: Context): MusicDatabase {
        return Room.databaseBuilder(
            context,
            MusicDatabase::class.java, "music_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    // MusicDao DI
    @Singleton
    @Provides
    fun provideMusicDao(musicDatabase: MusicDatabase): MusicDao {
        return musicDatabase.MusicDao()
    }

    // MusicLocalDataSource DI
    @Singleton
    @Provides
    fun provideMusicLocalDataSource(musicDao: MusicDao): MusicLocalDataSource {
        return MusicLocalDataSourceImpl(musicDao)
    }

    // AlbumDao DI
    @Singleton
    @Provides
    fun provideAlbumDao(musicDatabase: MusicDatabase): AlbumDao {
        return musicDatabase.AlbumDao()
    }

    // AlbumLocalDataSource DI
    @Singleton
    @Provides
    fun provideAlbumLocalDataSource(albumDao: AlbumDao): AlbumLocalDataSource {
        return AlbumLocalDataSourceImpl(albumDao)
    }


}