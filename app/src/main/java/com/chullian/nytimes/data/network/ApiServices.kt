package com.chullian.nytimes.data.network

import com.chullian.nytimes.data.model.responses.NewsDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServices {
    @GET("${topStories}/{section}.json}")
    suspend fun fetchSectionDetails(@Path("section") section: String = NewsSections.Home.value): NewsDetailResponse
}