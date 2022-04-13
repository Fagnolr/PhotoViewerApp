package com.example.photoviewerapp.domain.use_case.get_albums

import com.example.photoviewerapp.common.Resources
import com.example.photoviewerapp.data.remote.dto.AlbumDto
import com.example.photoviewerapp.data.remote.dto.toAlbum
import com.example.photoviewerapp.domain.model.Album
import com.example.photoviewerapp.domain.repository.PlaceHolderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val repository: PlaceHolderRepository
) {
    operator fun invoke(): Flow<Resources<List<Album>>> = flow {
        try {
            emit(Resources.Loading())
            val albums = repository.getAlbums().map { it.toAlbum() }
            emit(Resources.Success(albums))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An network error occurred"))
        } catch (e: IOException) {
            emit(Resources.Error("An network error occurred"))
        }
    }
}