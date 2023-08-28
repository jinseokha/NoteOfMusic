package com.devseok.data.repository.other.remote

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
interface OtherRemoteDataSource {
    fun getRecommendation() : Task<QuerySnapshot>
    fun getEssay() : Task<QuerySnapshot>
}