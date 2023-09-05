package com.devseok.presentation.view.music_list.insert

import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentMusicInsertBinding
import com.devseok.presentation.utils.repeatOnStarted
import com.devseok.presentation.view.music_list.MusicViewModel
import com.devseok.presentation.view.rating.RatingDialog
import com.devseok.presentation.view.rating.RatingListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
@AndroidEntryPoint
class MusicInsertFragment : BaseFragment<FragmentMusicInsertBinding>(R.layout.fragment_music_insert), RatingListener {

    private val musicViewModel by activityViewModels<MusicViewModel>()

    override fun init() {
        binding.apply {
            vm = musicViewModel
        }

        initViewModelCallback()
        initClickListener()
        initSpinner()
    }

    private fun initViewModelCallback() {
        repeatOnStarted {
            musicViewModel.inputErrorMsg.collectLatest {
                showToast(resources.getString(it))
            }
        }

        repeatOnStarted {
            musicViewModel.insertSuccessMsg.collectLatest {
                showToast(resources.getString(it))
                findNavController().navigateUp()
                findNavController().navigateUp()
            }
        }

        repeatOnStarted {
            musicViewModel.inputSuccessEvent.collectLatest {
                RatingDialog(requireContext(), this@MusicInsertFragment).show()
            }
        }
    }

    private fun initClickListener() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnCancel.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initSpinner() {
        val spinnerEntries = resources.getStringArray(R.array.genre)

        binding.spinnerGenre.apply {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    musicViewModel.setGenre(spinnerEntries[position])
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }
    }

    override fun onOkClick(rating: Float) {
        musicViewModel.insertMusic(rating)
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}