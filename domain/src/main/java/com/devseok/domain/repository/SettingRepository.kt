package com.devseok.domain.repository

import com.devseok.domain.model.setting.DomainInquiry
import com.google.android.gms.tasks.Task

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface SettingRepository {
    fun setInquiry(inquiry: DomainInquiry): Task<Void>
}