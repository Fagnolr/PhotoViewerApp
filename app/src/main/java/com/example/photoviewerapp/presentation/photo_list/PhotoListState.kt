package com.example.photoviewerapp.presentation.photo_list

import com.example.photoviewerapp.data.remote.dto.PhotoDto
import com.example.photoviewerapp.domain.model.Photo

data class PhotoListState(
    val isLoading: Boolean = false,
    val photos: List<Photo>? = emptyList(),
    val error: String = ""
)