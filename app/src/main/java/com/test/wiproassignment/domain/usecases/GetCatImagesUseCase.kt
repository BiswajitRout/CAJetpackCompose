package com.test.wiproassignment.domain.usecases

import com.test.wiproassignment.domain.repositories.CatRepository

class GetCatImagesUseCase(private val repository: CatRepository) {
    suspend operator fun invoke() = repository.getCatImages()
}