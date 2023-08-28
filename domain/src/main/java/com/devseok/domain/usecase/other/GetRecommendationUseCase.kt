package com.devseok.domain.usecase.other

import com.devseok.domain.repository.OtherRepository
import javax.inject.Inject

class GetRecommendationUseCase @Inject constructor(private val otherRepository: OtherRepository) {
    fun execute() = otherRepository.getRecommendation()
}