package com.devseok.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devseok.domain.utils.Result

object RecyclerViewBinding {

    // 검색 리사이클러뷰 아이템 바인딩
    @JvmStatic
    @BindingAdapter("submitList")
    fun bindSubmitList(view: RecyclerView, result: Result<*>) {
        if (result is Result.Success) {
            when (view.adapter) {

            }
        }
    }

}