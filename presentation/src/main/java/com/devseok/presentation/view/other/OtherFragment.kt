package com.devseok.presentation.view.other

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.activityViewModels
import com.devseok.domain.model.other.EssayResponse
import com.devseok.domain.model.other.RecommendationResponse
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentOtherBinding
import com.devseok.presentation.utils.repeatOnStarted
import com.devseok.presentation.view.other.essay.EssayAdapter
import com.devseok.presentation.view.other.essay.EssayAdapterListener
import com.devseok.presentation.view.other.recommendation.RecommendationAdapter
import com.devseok.presentation.view.other.recommendation.RecommendationAdapterListener
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

@AndroidEntryPoint
class OtherFragment : BaseFragmentMain<FragmentOtherBinding>(R.layout.fragment_other), RecommendationAdapterListener, EssayAdapterListener {

    private val otherViewModel by activityViewModels<OtherViewModel>()
    private val recommendationAdapter = RecommendationAdapter(this)
    private val essayAdapter = EssayAdapter(this)

    override fun init() {
        binding.apply {
            vm = otherViewModel

            recommendationRecyclerView.adapter = recommendationAdapter
            otherViewModel.getRecommendation()

            essayRecyclerView.adapter = essayAdapter
            otherViewModel.getEssay()
        }
        initViewModelCallback()
    }

    override fun onItemClicked(essay: EssayResponse) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(essay.uri))
        requireContext().startActivity(intent)
    }

    override fun onItemClicked(recommendation: RecommendationResponse) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=${recommendation.artist} ${recommendation.title}"))
        requireContext().startActivity(intent)
    }

    private fun initViewModelCallback(){
        repeatOnStarted {
            otherViewModel.recommendationList.collect{
                recommendationAdapter.submitList(it)
            }
        }
        repeatOnStarted {
            otherViewModel.essayList.collect{
                essayAdapter.submitList(it)
            }
        }
    }
}