package com.devseok.presentation.view.music_list.modify

import androidx.fragment.app.activityViewModels
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentMusicModifyBinding
import com.devseok.presentation.view.music_list.MusicViewModel
import com.devseok.presentation.view.rating.RatingListener
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */

@AndroidEntryPoint
class MusicModifyFragment : BaseFragment<FragmentMusicModifyBinding>(R.layout.fragment_music_modify), RatingListener {

    private val musicViewModel by activityViewModels<MusicViewModel>()

    override fun init() {

    }

    override fun onOkClick(rating: Float) {

    }
}