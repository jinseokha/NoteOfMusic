package com.devseok.presentation.view.album_list.list

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.domain.model.album.Album
import com.devseok.presentation.R
import com.devseok.presentation.databinding.DialogBottomSheetBinding
import com.devseok.presentation.utils.showDeleteDialog
import com.devseok.presentation.view.album_list.AlbumViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumBottomSheet (private val album: Album): BottomSheetDialogFragment() {

    private var _binding: DialogBottomSheetBinding? = null
    val binding get() = _binding!!

    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.dialog_bottom_sheet, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        init()
    }

    private fun init() {
        initClickListener()
    }

    private fun initClickListener() {
        binding.apply {
            textStart.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=${album.artist} ${album.title}"))
                requireContext().startActivity(intent)
                dismiss()
            }

            textDelete.setOnClickListener {
                showDeleteDialog(requireContext()) { dialogPositiveButtonClicked() }
            }

            textModify.setOnClickListener {
                albumViewModel.setAlbum(album)
                findNavController().navigate(R.id.action_albumListFragment_to_albumModifyFragment)
                dismiss()
            }

            textCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun dialogPositiveButtonClicked() {
        albumViewModel.deleteAlbum(album.id)
        Toast.makeText(requireContext(), (resources.getString(R.string.delete_success)), Toast.LENGTH_SHORT).show()
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}