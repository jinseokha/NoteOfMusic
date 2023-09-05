package com.devseok.presentation.view.music_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devseok.domain.utils.Result
import com.devseok.domain.model.music.DomainMusicResponse
import com.devseok.domain.model.music.Music
import com.devseok.domain.usecase.music.DeleteAllMusicUseCase
import com.devseok.domain.usecase.music.DeleteMusicUseCase
import com.devseok.domain.usecase.music.GetAllMusicByCategoryUseCase
import com.devseok.domain.usecase.music.GetAllMusicByRatingUseCase
import com.devseok.domain.usecase.music.GetAllMusicCountUseCase
import com.devseok.domain.usecase.music.GetAllMusicUseCase
import com.devseok.domain.usecase.music.GetRemoteMusicsUseCase
import com.devseok.domain.usecase.music.InsertMusicUseCase
import com.devseok.domain.usecase.music.UpdateMusicUseCase
import com.devseok.presentation.R
import com.devseok.presentation.utils.TIME_DESC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
@HiltViewModel
class MusicViewModel @Inject constructor(
    private val insertMusicUseCase: InsertMusicUseCase,
    private val getAllMusicUseCase: GetAllMusicUseCase,
    private val getAllMusicByRatingUseCase: GetAllMusicByRatingUseCase,
    private val getAllMusicByCategoryUseCase: GetAllMusicByCategoryUseCase,
    private val getRemoteMusicsUseCase: GetRemoteMusicsUseCase,
    private val deleteMusicUseCase: DeleteMusicUseCase,
    private val updateMusicUseCase: UpdateMusicUseCase,
    private val getAllMusicCountUseCase: GetAllMusicCountUseCase,
    private val deleteAllMusicUseCase: DeleteAllMusicUseCase
) : ViewModel() {

    val id: MutableStateFlow<Int> = MutableStateFlow(0)
    val image: MutableStateFlow<String> = MutableStateFlow("")
    val title: MutableStateFlow<String> = MutableStateFlow("")
    val artist: MutableStateFlow<String> = MutableStateFlow("")
    val genre: MutableStateFlow<String> = MutableStateFlow("장르")
    val summary: MutableStateFlow<String> = MutableStateFlow("")
    val content: MutableStateFlow<String> = MutableStateFlow("")

    val filterGenre: MutableStateFlow<String> = MutableStateFlow("전체")
    val filterStart: MutableStateFlow<Float> = MutableStateFlow(0.0f)
    val filterEnd: MutableStateFlow<Float> = MutableStateFlow(5.0f)
    val filterSort: MutableStateFlow<Int> = MutableStateFlow(0)

    private val _inputErrorMsg = MutableSharedFlow<Int>()
    val inputErrorMsg = _inputErrorMsg.asSharedFlow()
    private val _inputSuccessEvent = MutableSharedFlow<String>()
    val inputSuccessEvent = _inputSuccessEvent.asSharedFlow()
    private val _insertSuccessMsg = MutableSharedFlow<Int>()
    val insertSuccessMsg = _insertSuccessMsg.asSharedFlow()

    private val _remoteMusics: MutableStateFlow<Result<List<DomainMusicResponse>>> =
        MutableStateFlow(Result.Uninitialized)
    val remoteMusics get() = _remoteMusics.asStateFlow()

    // 검색 결과 클릭시 결과 정보 불러옴
    fun setMusicInfo(musicInfo: DomainMusicResponse) {
        image.value = musicInfo.image
        title.value = musicInfo.title
        artist.value = musicInfo.artist
        genre.value = ""
        summary.value = ""
        content.value = ""
    }

    // 수정 버튼 클릭 시 기존의 정보 불러옴
    fun setMusic(music: Music) {
        id.value = music.id
        image.value = music.image
        title.value = music.title
        artist.value = music.artist
        genre.value = music.genre
        summary.value = music.summary
        content.value = music.content
    }

    // 직접 추가시 모든 정보 초기화
    fun initMusicInfo() {
        image.value = ""
        title.value = ""
        artist.value = ""
        genre.value = ""
        summary.value = ""
        content.value = ""
    }

    // 장르 스피너 선택 결과
    fun setGenre(selected: String) {
        genre.value = selected
    }

    fun setFilterSort(type: Int) {
        filterSort.value = type
    }

    private fun setFilterAll(genre: String, start: Float, end: Float, type: Int) {
        filterGenre.value = genre
        filterStart.value = start
        filterEnd.value = end
        filterSort.value = type
    }

    fun insertMusic(rating: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            insertMusicUseCase.execute(
                Music(
                    image = image.value,
                    title = title.value,
                    artist = artist.value,
                    genre = genre.value,
                    rating = rating,
                    summary = summary.value,
                    content = content.value
                )
            )
            _insertSuccessMsg.emit(R.string.insert_success)
        }
    }

    var musicList: StateFlow<Result<List<Music>>> =
        getAllMusicUseCase.execute().stateIn(
            scope = viewModelScope,
            started= SharingStarted.WhileSubscribed(5000),
            initialValue = Result.Uninitialized
        )

    fun resetMusicList() {
        musicList = getAllMusicUseCase.execute().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Result.Uninitialized
        )

        setFilterAll("전체", 0.0f, 5.0f, TIME_DESC)
    }

    fun changeMusicList(start: Float, end: Float, genre: String) {
        if (genre == "전체") {
            musicList = getAllMusicByRatingUseCase.execute(start, end).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Result.Uninitialized
            )
        } else {
            musicList = getAllMusicByCategoryUseCase.execute(start, end, genre).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Result.Uninitialized
            )
        }
        setFilterAll(genre, start, end, filterSort.value)
    }

    fun getRemoteMusics(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getRemoteMusicsUseCase.execute(keyword).collectLatest {
                _remoteMusics.value = it
            }
        }
    }

    fun deleteMusic(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteMusicUseCase.execute(id)
        }
    }

    fun updateMusic(rating: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            updateMusicUseCase.execute(id.value, title.value, artist.value, genre.value, rating, summary.value, content.value)
            _insertSuccessMsg.emit(R.string.update_success)
        }
    }

    var musicCount: StateFlow<Result<Int>> =
        getAllMusicCountUseCase.execute().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Result.Uninitialized
        )

    fun deleteAllMusic() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllMusicUseCase.execute()
        }
    }

    fun inputCheck() {
        viewModelScope.launch(Dispatchers.IO) {
            when {
                title.value.isBlank() -> {
                    _inputErrorMsg.emit(R.string.error_title)
                }
                artist.value.isBlank() -> {
                    _inputErrorMsg.emit(R.string.error_artist)
                }
                summary.value.isBlank() ->{
                    _inputErrorMsg.emit(R.string.error_summary)
                }
                content.value.isBlank() ->{
                    _inputErrorMsg.emit(R.string.error_content)
                }
                genre.value == "장르" ->{
                    _inputErrorMsg.emit(R.string.error_genre)
                }else -> {
                _inputSuccessEvent.emit("검사 성공")
            }
            }
        }
    }

}