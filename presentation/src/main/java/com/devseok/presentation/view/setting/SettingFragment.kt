package com.devseok.presentation.view.setting

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentSettingBinding
import com.devseok.presentation.utils.LIST_TYPE
import com.devseok.presentation.utils.showDeleteDialog
import com.devseok.presentation.view.MainViewModel
import com.devseok.presentation.view.album_list.AlbumViewModel
import com.devseok.presentation.view.music_list.MusicViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

@AndroidEntryPoint
class SettingFragment : BaseFragmentMain<FragmentSettingBinding>(R.layout.fragment_setting) {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val musicViewModel by viewModels<MusicViewModel>()
    private val albumViewModel by viewModels<AlbumViewModel>()

    @Inject
    lateinit var sharedPref: SharedPreferences

    override fun init() {
        binding.apply {
            mainVm = mainViewModel
            musicVm = musicViewModel
            albumVm = albumViewModel
        }
        initSwitch()
        initClickListener()
    }

    private fun initSwitch() {
        binding.apply {
            switchLayoutType.isChecked = sharedPref.getInt(LIST_TYPE,0) != 0
            switchLayoutType.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    sharedPref.edit().putInt(LIST_TYPE, 1).apply()
                }else{
                    sharedPref.edit().putInt(LIST_TYPE, 0).apply()
                }
                mainViewModel.setListViewType()
                mainViewModel.setListViewTypeAlbum()
            }
        }
    }

    private fun initClickListener() {
        binding.apply {
            textDataMusicDelete.setOnClickListener {
                showDeleteDialog(requireContext()){
                    musicViewModel.deleteAllMusic()
                    showToast(resources.getString(R.string.delete_success))
                }
            }
            textDataAlbumDelete.setOnClickListener {
                showDeleteDialog(requireContext()){
                    albumViewModel.deleteAllAlbum()
                    showToast(resources.getString(R.string.delete_success))
                }
            }
            textDataSetting.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_dataSettingFragment)
            }
            textLockSetting.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_lockSettingFragment)
            }
            textReview.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${requireContext().packageName}" ))
                requireContext().startActivity(intent)
            }
            textInquiry.setOnClickListener {
                findNavController().navigate(R.id.action_settingFragment_to_inquiryFragment)
            }
        }
    }

}