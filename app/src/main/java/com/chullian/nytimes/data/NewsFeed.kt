package com.chullian.nytimes.data

/**
 * Created by binMammootty on 24/05/2022.
 */
data class NewsFeed(
    val title: String = "",
    val abstract: String = "",
    val url: String = "",
    val byline: String = "",
    val itemType: String = "",
    val updated_date: String = "",
    val descriptionFacet: List<String> = emptyList(),
    val personFacet: List<String> = emptyList(),
    val multimedia: List<NewsMedia> = emptyList()
)

data class NewsMedia(
    val url: String = "",
    val type: String = "",
    val copyright: String = "",
    val subtype: String = "",
)
