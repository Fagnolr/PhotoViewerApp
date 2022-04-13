package com.example.photoviewerapp.presentation.photo_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photoviewerapp.common.Constants
import com.example.photoviewerapp.common.Resources
import com.example.photoviewerapp.domain.use_case.get_photos.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PhotoListState())
    val state: State<PhotoListState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_ALBUM_ID)?.let { albumId ->
            getPhotos(albumId)
        }
    }

    private fun getPhotos(albumId: String) {
        getPhotosUseCase(albumId).onEach { result ->
            when (result) {
                is Resources.Success -> {
                    _state.value = PhotoListState(photos = result.data ?: emptyList())
                }
                is Resources.Error -> {
                    _state.value = PhotoListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resources.Loading -> {
                    _state.value = PhotoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}