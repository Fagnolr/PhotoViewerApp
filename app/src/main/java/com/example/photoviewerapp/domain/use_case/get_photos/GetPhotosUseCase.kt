package com.example.photoviewerapp.domain.use_case.get_photos

import com.example.photoviewerapp.common.Resources
import com.example.photoviewerapp.data.remote.dto.PhotoDto
import com.example.photoviewerapp.data.remote.dto.toPhoto
import com.example.photoviewerapp.domain.model.Photo
import com.example.photoviewerapp.domain.repository.PlaceHolderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: PlaceHolderRepository
) {
    operator fun invoke(albumId: String): Flow<Resources<List<Photo>>> = flow {
        try {
            emit(Resources.Loading())
            val photos = repository.getPhotos(albumId).map { it.toPhoto() }
            emit(Resources.Success(photos))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An network error occurred"))
        } catch (e: IOException) {
            emit(Resources.Error("An network error occurred"))
        }
    }
}