package com.devseok.presentation.view.other.recommendation

import com.devseok.domain.model.other.RecommendationResponse

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
interface RecommendationAdapterListener {
    fun onItemClicked(recommendation : RecommendationResponse)
}