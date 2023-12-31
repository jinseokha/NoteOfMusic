package com.devseok.presentation.view.rating

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.devseok.presentation.R
import com.devseok.presentation.databinding.DialogMusicRatingBinding

/**
 * @author Ha Jin Seok
 * @created 2023-09-05
 * @desc
 */
class RatingDialog(context: Context, private val listener: RatingListener): Dialog(context) {

    private lateinit var binding: DialogMusicRatingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.dialog_music_rating, null, false)
        setContentView(binding.root)

        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        initClickListener()
    }

    private fun initClickListener() {
        binding.apply {
            btnOk.setOnClickListener {
                listener.onOkClick(ratingBarPopup.rating)
                dismiss()
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }
}