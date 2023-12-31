package com.devseok.presentation.view.album_list.insert

import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentAlbumInsertBinding
import com.devseok.presentation.utils.repeatOnStarted
import com.devseok.presentation.view.album_list.AlbumViewModel
import com.devseok.presentation.view.rating.RatingDialog
import com.devseok.presentation.view.rating.RatingListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class AlbumInsertFragment : BaseFragment<FragmentAlbumInsertBinding>(R.layout.fragment_album_insert), RatingListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun init() {
        binding.apply {
            vm = albumViewModel
        }

        initViewModelCallback()
        initClickListener()
        initSpinner()
    }

    private fun initViewModelCallback() {
        repeatOnStarted {
            albumViewModel.inputErrorMsg.collectLatest {
                showToast(resources.getString(it))
            }
        }

        repeatOnStarted {
            albumViewModel.insertSuccessMsg.collectLatest {
                showToast(resources.getString(it))
                findNavController().navigateUp()
                findNavController().navigateUp()
            }
        }

        repeatOnStarted {
            albumViewModel.inputSuccessEvent.collectLatest {
                albumViewModel.insertAlbum()
                //RatingDialog(requireContext(), this@AlbumInsertFragment).show()
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
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    albumViewModel.setGenre(spinnerEntries[position])
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }
    }

    override fun onOkClick(rating: Float) {
        albumViewModel.insertAlbum()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}