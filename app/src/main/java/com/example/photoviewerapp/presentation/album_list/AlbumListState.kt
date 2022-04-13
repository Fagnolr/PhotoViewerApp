package com.example.photoviewerapp.presentation.album_list

import com.example.photoviewerapp.data.remote.dto.AlbumDto
import com.example.photoviewerapp.domain.model.Album

data class AlbumListState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val albums: List<Album> = emptyList(),
    val error: String = ""
)