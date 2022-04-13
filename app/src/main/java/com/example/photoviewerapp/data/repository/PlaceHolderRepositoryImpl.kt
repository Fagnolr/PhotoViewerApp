package com.example.photoviewerapp.data.repository

import com.example.photoviewerapp.data.remote.PlaceHolderApi
import com.example.photoviewerapp.data.remote.dto.AlbumDto
import com.example.photoviewerapp.data.remote.dto.PhotoDto
import com.example.photoviewerapp.domain.repository.PlaceHolderRepository
import javax.inject.Inject

class PlaceHolderRepositoryImpl @Inject constructor(
    private val api : PlaceHolderApi
) : PlaceHolderRepository {
    override suspend fun getAlbums(): List<AlbumDto> {
        return api.getAlbums()
    }

    override suspend fun getPhotos(albumId : String): List<PhotoDto> {
        return api.getPhotos(albumId)
    }
}