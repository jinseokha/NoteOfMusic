package com.devseok.presentation.view

import android.os.Bundle
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseActivity
import com.devseok.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Ha Jin Seok
 * @created 2023-08-25
 * @desc
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun init() {

    }
}