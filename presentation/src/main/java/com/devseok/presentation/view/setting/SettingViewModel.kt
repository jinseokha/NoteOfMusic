package com.devseok.presentation.view.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devseok.domain.model.setting.DomainInquiry
import com.devseok.domain.usecase.setting.SetInquiryUseCase
import com.devseok.presentation.R
import com.devseok.presentation.utils.timeDetailFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
@HiltViewModel
class SettingViewModel @Inject constructor(
    private val setInquiryUseCase: SetInquiryUseCase
) : ViewModel() {

    val content: MutableStateFlow<String> = MutableStateFlow("")
    val id: MutableStateFlow<String> = MutableStateFlow("익명")

    private val _successMsg = MutableSharedFlow<Int>()
    val successMsg = _successMsg.asSharedFlow()

    fun setInquiry() {
        viewModelScope.launch(Dispatchers.IO) {
            setInquiryUseCase.execute(
                DomainInquiry(
                    id = id.value,
                    content = content.value,
                    time = timeDetailFormatter(System.currentTimeMillis())
                )
            )
            _successMsg.emit(R.string.inquiry_success)
        }
    }

}