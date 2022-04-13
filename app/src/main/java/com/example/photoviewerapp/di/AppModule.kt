package com.example.photoviewerapp.di

import com.example.photoviewerapp.common.Constants
import com.example.photoviewerapp.data.remote.PlaceHolderApi
import com.example.photoviewerapp.data.repository.PlaceHolderRepositoryImpl
import com.example.photoviewerapp.domain.repository.PlaceHolderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlaceHolderApi() : PlaceHolderApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlaceHolderApi::class.java)
    }

   @Provides
   @Singleton
   fun providePlaceHolderRepository(api: PlaceHolderApi): PlaceHolderRepository {
       return PlaceHolderRepositoryImpl(api)
   }

}