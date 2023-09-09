package com.devseok.noteofmusic.di

import com.google.firebase.firestore.FirebaseFirestore
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
object FirebaseModule {

    // Firebase DI
    @Provides
    @Singleton
    fun provideFirebaseStore() : FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}