package com.example.photoviewerapp.data.remote.dto

import com.example.photoviewerapp.domain.model.Album

data class AlbumDto(
    val id: Int,
    val title: String,
    val userId: Int
)

fun AlbumDto.toAlbum() : Album {
    return Album(
        userId = userId,
        title = title,
        id = id
    )
}