package com.example.photoviewerapp.data.remote.dto

import com.example.photoviewerapp.domain.model.Photo

data class PhotoDto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        title = title,
        url = url
    )
}