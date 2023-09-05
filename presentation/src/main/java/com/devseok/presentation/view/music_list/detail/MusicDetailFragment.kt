package com.devseok.presentation.view.music_list.detail

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentMusicDetailBinding
import com.devseok.presentation.utils.showDeleteDialog
import com.devseok.presentation.view.music_list.MusicViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */

@AndroidEntryPoint
class MusicDetailFragment : BaseFragment<FragmentMusicDetailBinding>(R.layout.fragment_music_detail){

    private val args by navArgs<MusicDetailFragmentArgs>()
    private val musicViewModel by activityViewModels<MusicViewModel>()

    override fun init() {
        binding.apply {
            music = args.music
            toolbar.inflateMenu(R.menu.menu_option)
        }

        initClickListener()
    }

    private fun initClickListener() {
        binding.apply {
            toolbar.apply {
                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }

                setOnMenuItemClickListener {item ->
                    when(item?.itemId) {
                        R.id.menu_play -> {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=${args.music.artist} ${args.music.title}"))
                            requireContext().startActivity(intent)
                        }
                        R.id.menu_modify -> {
                            musicViewModel.setMusic(args.music)
                            findNavController().navigate(R.id.action_musicDetailFragment_to_musicModifyFragment)
                        }
                        R.id.menu_delete ->{
                            showDeleteDialog(requireContext()) { dialogPositiveButtonClicked() }
                        }
                    }

                    false
                }
            }
        }
    }

    private fun dialogPositiveButtonClicked(){
        musicViewModel.deleteMusic(args.music.id)
        showToast(resources.getString(R.string.delete_success))
        findNavController().popBackStack()
    }
}