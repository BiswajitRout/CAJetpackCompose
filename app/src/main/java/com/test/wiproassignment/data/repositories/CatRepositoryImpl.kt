package com.test.wiproassignment.data.repositories

import com.test.wiproassignment.data.remote.CatApiService
import com.test.wiproassignment.domain.entities.CatImage
import com.test.wiproassignment.domain.repositories.CatRepository

class CatRepositoryImpl(private val apiService: CatApiService) : CatRepository {
    override suspend fun getCatImages(): List<CatImage> = apiService.getCatImages()
}