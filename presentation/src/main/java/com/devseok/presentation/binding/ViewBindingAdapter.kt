package com.devseok.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.devseok.presentation.R

object ViewBindingAdapter {

    @BindingAdapter("searchImage")
    @JvmStatic
    fun ImageView.setSearchImage(imageUrl: Any) {
        Glide.with(this.context)
            .load(imageUrl)
            .override(R.dimen.search_image_size * 2, R.dimen.search_image_size * 2)
            .placeholder(R.drawable.image_loading)
            .into(this)
        this.clipToOutline = true
    }


}