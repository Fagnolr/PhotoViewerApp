package com.example.photoviewerapp.presentation.album_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photoviewerapp.common.Resources
import com.example.photoviewerapp.domain.use_case.get_albums.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AlbumListState())
    val state: State<AlbumListState> = _state

    init {
        getAlbums(isRefreshing = false)
    }

    fun getAlbums(isRefreshing: Boolean) {
        getAlbumsUseCase().onEach { result ->
            when (result) {
                is Resources.Success -> {
                    _state.value =
                        AlbumListState(albums = result.data?.sortedBy { it.title } ?: emptyList())
                }
                is Resources.Error -> {
                    _state.value = AlbumListState(error = result.message ?: "An error occurred")
                }
                is Resources.Loading -> {
                    _state.value = AlbumListState(isLoading = true, isRefreshing = isRefreshing)
                }
            }
        }.launchIn(viewModelScope)
    }
}