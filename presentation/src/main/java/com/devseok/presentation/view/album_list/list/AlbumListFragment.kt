package com.devseok.presentation.view.album_list.list

import android.content.SharedPreferences
import android.view.WindowManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.devseok.domain.model.album.Album
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentAlbumListBinding
import com.devseok.presentation.utils.LIST_TYPE
import com.devseok.presentation.view.MainViewModel
import com.devseok.presentation.view.album_list.AlbumViewModel
import com.devseok.presentation.view.category.CategoryDialogListener
import com.devseok.presentation.view.sort.SortListener
import com.devseok.domain.utils.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

@AndroidEntryPoint
class AlbumListFragment : BaseFragmentMain<FragmentAlbumListBinding>(R.layout.fragment_album_list),
    AlbumListAdapterListener, SortListener, CategoryDialogListener {

    private val albumViewModel by viewModels<AlbumViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val albumListAdapter = AlbumListAdapter(this)

    private lateinit var searchView : SearchView
    private lateinit var job : Job

    @Inject
    lateinit var sharedPref: SharedPreferences

    override fun init() {
        albumListAdapter.setHasStableIds(true)

        binding.apply {
            vm = albumViewModel
            toolbar.inflateMenu(R.menu.menu_music_list_option)
        }

        initSearchView()
        initAdapter()
        initClickListener()
        initViewModelCallback()
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
                albumListAdapter.filter.filter(newText?.lowercase())
                return false
            }
        })

    }

    private fun initClickListener() {
        binding.apply {

        }
    }

    private fun initAdapter() {
        albumListAdapter.setListViewType(sharedPref.getInt(LIST_TYPE, 0))
        binding.apply {
            recyclerViewAlbumList.adapter = albumListAdapter
        }
    }

    private fun initViewModelCallback() {
        collectMusicList()

        lifecycleScope.launchWhenStarted {
            mainViewModel.listViewTypeAlbum.collectLatest {
                initAdapter()
            }
        }
    }

    private fun jobUpdate(logic: () -> Unit) {
        job.cancel()
        logic()
        collectMusicList()
    }

    private fun collectMusicList() {
        job = lifecycleScope.launchWhenStarted {

        }
    }

    override fun onItemClicked(album: Album) {

    }

    override fun onOtherButtonClicked(album: Album) {

    }

    override fun onSortClicked(type: Int) {

    }

    override fun onCategorySelected(start: Float, end: Float, genre: String) {

    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }
}