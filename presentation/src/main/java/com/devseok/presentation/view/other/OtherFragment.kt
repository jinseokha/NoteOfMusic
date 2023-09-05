package com.devseok.presentation.view.other

import com.devseok.domain.model.other.EssayResponse
import com.devseok.domain.model.other.RecommendationResponse
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentOtherBinding
import com.devseok.presentation.view.other.essay.EssayAdapterListener
import com.devseok.presentation.view.other.recommendation.RecommendationAdapterListener
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

@AndroidEntryPoint
class OtherFragment : BaseFragmentMain<FragmentOtherBinding>(R.layout.fragment_other), RecommendationAdapterListener, EssayAdapterListener {

    override fun init() {

    }

    override fun onItemClicked(essay: EssayResponse) {

    }

    override fun onItemClicked(recommendation: RecommendationResponse) {

    }
}