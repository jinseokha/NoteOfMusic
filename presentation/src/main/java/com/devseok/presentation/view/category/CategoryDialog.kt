package com.devseok.presentation.view.category

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import com.devseok.presentation.R
import com.devseok.presentation.databinding.DialogCategoryBinding
import com.devseok.presentation.utils.dialogResize
import com.github.guilhe.views.SeekBarRangedView
import kotlin.math.round

class CategoryDialog(context: Context, private val listener: CategoryDialogListener): Dialog(context) {

    private lateinit var binding: DialogCategoryBinding

    private val stepList = listOf(10f, 20f, 30f, 40f, 50f, 60f, 70f, 80f, 90f)

    private val div = 20
    private var min = 0f
    private var max = 5f
    private var curGenre = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_category, null, false)
        setContentView(binding.root)

        context.dialogResize(this, 0.8f, 0.25f)

        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        initClickListener()
        initSeekBar()
        initSpinner()

    }

    private fun initClickListener() {
        binding.apply {
            btnOk.setOnClickListener {
                listener.onCategorySelected(min, max, curGenre)
                dismiss()
            }

            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun initSeekBar() {
        binding.seekBarRating.apply {
            enableProgressBySteps(true)
            setProgressSteps(stepList)
            actionCallback = object : SeekBarRangedView.SeekBarRangedChangeCallback {
                override fun onChanged(minValue: Float, maxValue: Float) {

                }

                override fun onChanging(minValue: Float, maxValue: Float) {
                    min = round(minValue * 2) / 2 / div
                    max = round(maxValue * 2) / 2 / div
                    binding.textMin.text = min.toString()
                    binding.textMax.text = max.toString()
                }
            }
        }
    }

    private fun initSpinner() {
        val spinnerEntries = context.resources.getStringArray(R.array.genre_filter)

        binding.spinnerGenre.apply {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    curGenre = spinnerEntries[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }
}