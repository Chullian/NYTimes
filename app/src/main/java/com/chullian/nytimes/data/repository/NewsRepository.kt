package com.chullian.nytimes.data.repository

import com.chullian.nytimes.data.model.responses.NewsDetailResponse
import com.chullian.nytimes.data.network.NewsSections
import kotlinx.coroutines.flow.Flow

/**
 * Created by binMammootty on 23/05/2022.
 */
interface NewsRepository {

    suspend fun fetchSectionDetail(sectionName:NewsSections):Flow<NewsDetailResponse>
}