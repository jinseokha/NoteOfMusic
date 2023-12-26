package com.devseok.noteofmusic.di

import com.devseok.data.api.MusicApi
import com.devseok.data.repository.album.remote.AlbumRemoteDataSource
import com.devseok.data.repository.album.remote.AlbumRemoteDataSourceImpl
import com.devseok.data.repository.music.remote.MusicRemoteDataSource
import com.devseok.data.repository.music.remote.MusicRemoteDataSourceImpl
import com.devseok.data.repository.other.remote.OtherRemoteDataSource
import com.devseok.data.repository.other.remote.OtherRemoteDataSourceImpl
import com.devseok.data.repository.setting.remote.SettingRemoteDataSource
import com.devseok.data.repository.setting.remote.SettingRemoteDataSourceImpl
import com.devseok.noteofmusic.utils.BASE_URL
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Ha Jin Seok
 * @created 2023-09-06
 * @desc
 */

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    // Retrofit DI
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {

        var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.DAYS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    // MusicApi DI
    @Provides
    @Singleton
    fun provideMusicApiService(retrofit: Retrofit): MusicApi {
        return retrofit.create(MusicApi::class.java)
    }

    // MusicRemoteDataSource DI
    @Singleton
    @Provides
    fun provideMusicRemoteDataSource(musicApi: MusicApi): MusicRemoteDataSource {
        return MusicRemoteDataSourceImpl(musicApi)
    }

    // AlbumRemoteDataSource DI
    @Singleton
    @Provides
    fun provideAlbumRemoteDataSource(musicApi: MusicApi): AlbumRemoteDataSource {
        return AlbumRemoteDataSourceImpl(musicApi)
    }

    // OtherRemoteDataSource DI
    @Singleton
    @Provides
    fun provideOtherRemoteDataSource(fireStore : FirebaseFirestore): OtherRemoteDataSource {
        return OtherRemoteDataSourceImpl(fireStore)
    }

    // SettingRemoteDataSource DI
    @Singleton
    @Provides
    fun provideSettingRemoteDataSource(fireStore : FirebaseFirestore): SettingRemoteDataSource {
        return SettingRemoteDataSourceImpl(fireStore)
    }
}