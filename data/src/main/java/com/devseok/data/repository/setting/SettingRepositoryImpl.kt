package com.devseok.data.repository.setting

import com.devseok.data.mapper.mapperToDataInquiry
import com.devseok.data.repository.setting.remote.SettingRemoteDataSource
import com.devseok.domain.model.setting.DomainInquiry
import com.devseok.domain.repository.SettingRepository
import com.google.android.gms.tasks.Task
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class SettingRepositoryImpl @Inject constructor(
    private val settingRemoteDataSource: SettingRemoteDataSource
) : SettingRepository {
    override fun setInquiry(inquiry: DomainInquiry): Task<Void>
            = settingRemoteDataSource.setInquiry(mapperToDataInquiry(inquiry))
}