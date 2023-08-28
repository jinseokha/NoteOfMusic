package com.devseok.data.repository.setting.remote

import com.devseok.data.model.setting.DataInquiry
import com.google.android.gms.tasks.Task

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface SettingRemoteDataSource {
    fun setInquiry(inquiry: DataInquiry): Task<Void>
}