package com.devseok.noteofmusic.di

import com.devseok.data.repository.album.AlbumRepositoryImpl
import com.devseok.data.repository.album.local.AlbumLocalDataSource
import com.devseok.data.repository.album.remote.AlbumRemoteDataSource
import com.devseok.data.repository.music.MusicRepositoryImpl
import com.devseok.data.repository.music.local.MusicLocalDataSource
import com.devseok.data.repository.music.remote.MusicRemoteDataSource
import com.devseok.data.repository.other.OtherRepositoryImpl
import com.devseok.data.repository.other.remote.OtherRemoteDataSource
import com.devseok.data.repository.setting.SettingRepositoryImpl
import com.devseok.data.repository.setting.remote.SettingRemoteDataSource
import com.devseok.domain.repository.AlbumRepository
import com.devseok.domain.repository.MusicRepository
import com.devseok.domain.repository.OtherRepository
import com.devseok.domain.repository.SettingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Ha Jin Seok
 * @created 2023-09-06
 * @desc
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    // MusicRepository DI
    @Provides
    @Singleton
    fun provideMusicRepository(
        musicLocalDataSource: MusicLocalDataSource,
        musicRemoteDataSource: MusicRemoteDataSource
    ): MusicRepository {
        return MusicRepositoryImpl(musicLocalDataSource, musicRemoteDataSource)
    }

    // AlbumRepository DI
    @Provides
    @Singleton
    fun provideAlbumRepository(
        albumLocalDataSource: AlbumLocalDataSource,
        albumRemoteDataSource: AlbumRemoteDataSource
    ): AlbumRepository {
        return AlbumRepositoryImpl(albumLocalDataSource, albumRemoteDataSource)
    }

    // OtherRepository DI
    @Provides
    @Singleton
    fun provideOtherRepository(
        otherRemoteDataSource: OtherRemoteDataSource
    ): OtherRepository {
        return OtherRepositoryImpl(otherRemoteDataSource)
    }

    // SettingRepository DI
    @Provides
    @Singleton
    fun provideSettingRepository(
        settingRemoteDataSource: SettingRemoteDataSource
    ): SettingRepository {
        return SettingRepositoryImpl(settingRemoteDataSource)
    }
}