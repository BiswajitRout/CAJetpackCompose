package com.test.wiproassignment.di

import com.test.wiproassignment.data.remote.CatApiService
import com.test.wiproassignment.data.repositories.CatRepositoryImpl
import com.test.wiproassignment.domain.repositories.CatRepository
import com.test.wiproassignment.domain.usecases.GetCatImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCatApiService(): CatApiService =
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApiService::class.java)

    @Provides
    fun provideCatRepository(apiService: CatApiService): CatRepository =
        CatRepositoryImpl(apiService)

    @Provides
    fun provideGetCatImagesUseCase(repository: CatRepository): GetCatImagesUseCase =
        GetCatImagesUseCase(repository)
}