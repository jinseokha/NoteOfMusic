package com.devseok.presentation.view.album_list.search

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.domain.model.album.DomainAlbumResponse
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragmentMain
import com.devseok.presentation.databinding.FragmentAlbumSearchBinding
import com.devseok.presentation.view.album_list.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlbumSearchFragment : BaseFragmentMain<FragmentAlbumSearchBinding>(R.layout.fragment_album_search), AlbumSearchAdapterListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()
    private val albumSearchAdapter = AlbumSearchAdapter(this)

    override fun init() {
        binding.apply {
            vm = albumViewModel
            recyclerViewAlbumSearchList.adapter = albumSearchAdapter
        }

        initSearchView()
        initClickListener()
    }

    private fun initSearchView() {
        binding.searchViewMusic.apply {
            val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            CoroutineScope(Dispatchers.Main).launch {
                inputMethodManager.showSoftInput(this@apply, 0)
            }
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    albumViewModel.getRemoteAlbums(query)
                    clearFocus()
                    return true
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }

    private fun initClickListener() {
        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
            textDirect.setOnClickListener {
                albumViewModel.initAlbumInfo()
                findNavController().navigate(R.id.action_albumSearchFragment_to_albumInsertFragment)
            }
        }
    }

    override fun onItemClicked(albumInfo: DomainAlbumResponse) {
        albumViewModel.setAlbumInfo(albumInfo)
        findNavController().navigate(R.id.action_albumSearchFragment_to_albumInsertFragment)
    }
}