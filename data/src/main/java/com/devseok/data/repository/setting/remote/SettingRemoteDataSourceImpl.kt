package com.devseok.data.repository.setting.remote

import com.devseok.data.model.setting.DataInquiry
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class SettingRemoteDataSourceImpl @Inject constructor(
    private val fireStore : FirebaseFirestore
) : SettingRemoteDataSource {
    override fun setInquiry(inquiry: DataInquiry): Task<Void> = fireStore.collection("inquiry").document().set(inquiry)
}