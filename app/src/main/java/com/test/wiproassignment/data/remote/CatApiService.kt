package com.test.wiproassignment.data.remote

import com.test.wiproassignment.domain.entities.CatImage
import retrofit2.http.GET

interface CatApiService {

    @GET("v1/images/search?limit=20")
    suspend fun getCatImages(): List<CatImage>
}