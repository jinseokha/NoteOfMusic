package com.devseok.domain.usecase.setting

import com.devseok.domain.model.setting.DomainInquiry
import com.devseok.domain.repository.SettingRepository
import javax.inject.Inject

class SetInquiryUseCase @Inject constructor(private val settingRepository: SettingRepository) {
    fun execute(inquiry: DomainInquiry) = settingRepository.setInquiry(inquiry)
}