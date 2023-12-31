package com.devseok.presentation.view.setting.inquiry

import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentInquiryBinding
import com.devseok.presentation.utils.repeatOnStarted
import com.devseok.presentation.view.setting.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class InquiryFragment : BaseFragment<FragmentInquiryBinding>(R.layout.fragment_inquiry) {

    private val settingViewModel by viewModels<SettingViewModel>()
    override fun init() {
        binding.apply {
            vm = settingViewModel
        }

        initClickListener()
        initViewModelCallback()
    }

    private fun initClickListener() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnCancel.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun initViewModelCallback() {
        repeatOnStarted {
            settingViewModel.successMsg.collectLatest {
                showToast(resources.getString(it))
                findNavController().navigateUp()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}