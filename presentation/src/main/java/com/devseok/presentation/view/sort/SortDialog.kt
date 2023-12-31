package com.devseok.presentation.view.sort

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.devseok.presentation.R
import com.devseok.presentation.databinding.DialogSortBinding
import com.devseok.presentation.utils.RATING_ASC
import com.devseok.presentation.utils.RATING_DESC
import com.devseok.presentation.utils.TIME_ASC
import com.devseok.presentation.utils.TIME_DESC
import com.devseok.presentation.utils.TITLE_ASC
import com.devseok.presentation.utils.TITLE_DESC
import com.devseok.presentation.utils.dialogResize

class SortDialog(context: Context, private val listener: SortListener): Dialog(context) {

    private lateinit var binding: DialogSortBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_sort, null, false)
        setContentView(binding.root)

        context.dialogResize(this, 0.6f, 0.4f)

        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        initClickListener()
    }

    private fun initClickListener() {
        binding.apply {
            textTimeDesc.setOnClickListener {
                listener.onSortClicked(TIME_DESC)
                dismiss()
            }
            textTimeAsc.setOnClickListener {
                listener.onSortClicked(TIME_ASC)
                dismiss()
            }
            textTitleAsc.setOnClickListener {
                listener.onSortClicked(TITLE_ASC)
                dismiss()
            }
            textTitleDesc.setOnClickListener {
                listener.onSortClicked(TITLE_DESC)
                dismiss()
            }
            textRatingDesc.setOnClickListener {
                listener.onSortClicked(RATING_DESC)
                dismiss()
            }
            textRatingAsc.setOnClickListener {
                listener.onSortClicked(RATING_ASC)
                dismiss()
            }
            textCancel.setOnClickListener {
                dismiss()
            }
        }
    }
}