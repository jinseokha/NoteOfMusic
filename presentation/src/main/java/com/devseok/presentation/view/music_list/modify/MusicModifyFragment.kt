package com.devseok.presentation.view.music_list.modify

import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentMusicModifyBinding
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
class MusicModifyFragment : BaseFragment<FragmentMusicModifyBinding>(R.layout.fragment_music_modify), RatingListener {

    private val musicViewModel by activityViewModels<MusicViewModel>()

    override fun init() {
        binding.apply {
            vm = musicViewModel
        }

        initViewModelCallback()
        initClickListener()
        initSpinner()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    override fun onOkClick(rating: Float) {
        musicViewModel.updateMusic(rating)
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
                musicViewModel.insertMusic()
                //RatingDialog(requireContext(), this@MusicModifyFragment).show()
            }
        }
    }

    private fun initClickListener() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            /*btnCancel.setOnClickListener {
                findNavController().popBackStack()
            }*/
        }
    }

    private fun initSpinner() {
        val spinnerEntries = resources.getStringArray(R.array.genre)

        binding.spinnerGenre.apply {
            for(i in spinnerEntries.indices) {
                if (musicViewModel.genre.value == spinnerEntries[i]) {
                    setSelection(i)
                    break
                }
            }

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    musicViewModel.setGenre(spinnerEntries[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }


}