package com.devseok.data.repository.other

import com.devseok.data.repository.other.remote.OtherRemoteDataSource
import com.devseok.domain.repository.OtherRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
class OtherRepositoryImpl @Inject constructor(
    private val otherRemoteDataSource: OtherRemoteDataSource
) : OtherRepository {
    override fun getRecommendation(): Task<QuerySnapshot> = otherRemoteDataSource.getRecommendation()
    override fun getEssay(): Task<QuerySnapshot> = otherRemoteDataSource.getEssay()
}