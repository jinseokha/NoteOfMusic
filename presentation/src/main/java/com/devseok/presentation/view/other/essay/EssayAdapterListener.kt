package com.devseok.presentation.view.other.essay

import com.devseok.domain.model.other.EssayResponse

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
interface EssayAdapterListener {
    fun onItemClicked(essay : EssayResponse)
}