package com.example.photoviewerapp.data.remote

import com.example.photoviewerapp.data.remote.dto.AlbumDto
import com.example.photoviewerapp.data.remote.dto.PhotoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceHolderApi {
    @GET("albums")
    suspend fun getAlbums(): List<AlbumDto>

    @GET("albums/{albumId}/photos")
    suspend fun getPhotos(@Path("albumId") albumId : String): List<PhotoDto>
}