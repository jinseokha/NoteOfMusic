package com.devseok.presentation.view

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseActivity
import com.devseok.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import de.raphaelebner.roomdatabasebackup.core.RoomBackup
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

/**
 * @author Ha Jin Seok
 * @created 2023-08-25
 * @desc
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    lateinit var backup: RoomBackup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        backup = RoomBackup(this)
    }

    override fun init() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_view) as NavHostFragment
        val navController = navHostFragment.navController


        ExpandableBottomBarNavigationUI.setupWithNavController(binding.expandableBottomBar, navController)
    }
}