package com.devseok.presentation.view.music_list.list

import android.content.SharedPreferences
import android.os.Build
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.devseok.domain.model.music.Music
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentMusicListBinding
import com.devseok.presentation.view.MainViewModel
import com.devseok.presentation.view.category.CategoryDialogListener
import com.devseok.presentation.view.music_list.MusicViewModel
import com.devseok.presentation.view.sort.SortListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */
@AndroidEntryPoint
class MusicListFragment : BaseFragmentMain<FragmentMusicListBinding>(R.layout.fragment_music_list), MusicListAdapterListener, SortListener, CategoryDialogListener {

    private val musicViewModel by viewModels<MusicViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val musicListAdapter = MusicListAdapter(this)

    private lateinit var searchView: SearchView
    private lateinit var job: Job

    @Inject
    lateinit var sharedPref: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.N)
    override fun init() {
        musicListAdapter.setHasStableIds(true)

        binding.apply {
            vm = musicViewModel
            toolbar.inflateMenu(R.menu.menu_music_list_option)
        }

        initSearchView()
        initAdapter()
        initClickListener()
        initViewModelCallback()
    }

    override fun onCategorySelected(start: Float, end: Float, genre: String) {

    }

    override fun onItemClicked(music: Music) {

    }

    override fun onOtherButtonClicked(music: Music) {

    }

    override fun onSortClicked(type: Int) {

    }

    private fun initSearchView() {
        val search = binding.toolbar.menu.findItem(R.id.menu_search)
        searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                musicListAdapter.filter.filter(newText?.lowercase())
                return false
            }
        })
    }

    private fun initAdapter() {

    }

    private fun initClickListener() {

    }

    private fun initViewModelCallback() {

    }

}