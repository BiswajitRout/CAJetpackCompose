package com.test.wiproassignment.domain.repositories

import com.test.wiproassignment.domain.entities.CatImage

interface CatRepository {
    suspend fun getCatImages(): List<CatImage>
}