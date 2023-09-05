package com.devseok.presentation.view.music_list.search

import androidx.fragment.app.activityViewModels
import com.devseok.domain.model.music.DomainMusicResponse
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentMusicSearchBinding
import com.devseok.presentation.view.music_list.MusicViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
@AndroidEntryPoint
class MusicSearchFragment: BaseFragmentMain<FragmentMusicSearchBinding>(R.layout.fragment_music_search), MusicSearchAdapterListener {

    private val musicViewModel by activityViewModels<MusicViewModel>()


    override fun init() {
        binding.apply {
            vm = musicViewModel
            //recyclerViewMusicSearchList.adapter
        }
    }

    override fun onItemClicked(musicInfo: DomainMusicResponse) {

    }
}