package com.chullian.nytimes.data.repository

import com.chullian.nytimes.data.model.responses.NewsDetailResponse
import com.chullian.nytimes.data.network.ApiServices
import com.chullian.nytimes.data.network.NewsSections
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NewsRepositoryImpl(
    private val network:ApiServices
) : NewsRepository{

    override suspend fun fetchSectionDetail(sectionName: NewsSections): Flow<NewsDetailResponse> {
        val result = network.fetchSectionDetails(sectionName.value)
        return flowOf(result)
    }
}