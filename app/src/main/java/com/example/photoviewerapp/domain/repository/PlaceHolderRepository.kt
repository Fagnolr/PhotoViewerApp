package com.example.photoviewerapp.domain.repository

import com.example.photoviewerapp.data.remote.dto.AlbumDto
import com.example.photoviewerapp.data.remote.dto.PhotoDto

interface PlaceHolderRepository {
    suspend fun getAlbums(): List<AlbumDto>

    suspend fun getPhotos(albumId: String): List<PhotoDto>
}