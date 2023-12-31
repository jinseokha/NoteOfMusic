package com.devseok.data.repository.music

import com.devseok.data.mapper.mapperToMusic
import com.devseok.data.mapper.mapperToMusicEntity
import com.devseok.data.mapper.mapperToMusicResponse
import com.devseok.data.repository.music.local.MusicLocalDataSource
import com.devseok.data.repository.music.remote.MusicRemoteDataSource
import com.devseok.domain.model.music.DomainMusicResponse
import com.devseok.domain.model.music.Music
import com.devseok.domain.repository.MusicRepository
import com.devseok.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class MusicRepositoryImpl @Inject constructor(
    private val musicLocalDataSource: MusicLocalDataSource,
    private val musicRemoteDataSource: MusicRemoteDataSource
) : MusicRepository {
    override fun insertMusic(music: Music) = musicLocalDataSource.insertMusic(mapperToMusicEntity(music))

    override fun getAllMusic(): Flow<Result<List<Music>>> = flow {
        emit(Result.Loading)
        musicLocalDataSource.getAllMusic().collect {
            if (it.isEmpty()) {
                emit(Result.Empty)
            } else {
                emit(Result.Success(mapperToMusic(it)))
            }
        }
    }.catch { e ->
        emit(Result.Error(e))
    }

    override fun getRemoteMusics(keyword: String): Flow<Result<List<DomainMusicResponse>>> = flow {
        emit(Result.Loading)
        musicRemoteDataSource.getRemoteMusics(keyword).collect {
            emit(Result.Success(mapperToMusicResponse(it)))
        }
    }.catch { e ->
        emit(Result.Error(e))
    }

    override fun deleteMusic(id: Int) = musicLocalDataSource.deleteMusic(id)

    override fun updateMusic(
        id: Int,
        title: String,
        artist: String,
        genre: String,
        rating: Float,
        summary: String,
        content: String
    ) = musicLocalDataSource.updateMusic(id, title, artist, genre, rating, summary, content)

    override fun getAllMusicByRating(start: Float, end: Float): Flow<Result<List<Music>>>
            = flow {
        emit(Result.Loading)
        musicLocalDataSource.getAllMusicByRating(start, end).collect {
            if(it.isEmpty()){
                emit(Result.Empty)
            }else{
                emit(Result.Success(mapperToMusic(it)))
            }
        }
    }.catch { e ->
        emit(Result.Error(e))
    }

    override fun getAllMusicByCategory(
        start: Float,
        end: Float,
        genre: String
    ): Flow<Result<List<Music>>> = flow {
        emit(Result.Loading)
        musicLocalDataSource.getAllMusicByCategory(start, end, genre).collect {
            if(it.isEmpty()){
                emit(Result.Empty)
            }else{
                emit(Result.Success(mapperToMusic(it)))
            }
        }
    }.catch { e ->
        emit(Result.Error(e))
    }

    override fun getAllMusicCount(): Flow<Result<Int>> = flow {
        emit(Result.Loading)
        musicLocalDataSource.getAllMusicCount().collect {
            emit(Result.Success(it))
        }
    }.catch { e ->
        emit(Result.Error(e))
    }

    override fun deleteAllMusic() = musicLocalDataSource.deleteAllMusic()
}