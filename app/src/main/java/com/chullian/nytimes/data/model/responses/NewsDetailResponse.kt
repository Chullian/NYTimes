package com.chullian.nytimes.data.model.responses

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Created by binMammootty on 23/05/2022.
 */

@Keep
@Serializable
data class NewsDetailResponse(
    @SerialName("copyright") val copyright: String?,
    @SerialName("last_updated") val lastUpdated: String?,
    @SerialName("num_results") val numResults: Int?,
    @SerialName("results") val results: List<NewsDetailResult?>?,
    @SerialName("section") val section: String?,
    @SerialName("status") val status: String?
)

@Keep
@Serializable
data class NewsDetailResult(
    @SerialName("abstract") val `abstract`: String?,
    @SerialName("byline") val byline: String?,
    @SerialName("created_date") val createdDate: String?,
    @SerialName("des_facet") val desFacet: List<String?>?,
    @SerialName("geo_facet") val geoFacet: List<String?>?,
    @SerialName("item_type") val itemType: String?,
    @SerialName("kicker") val kicker: String?,
    @SerialName("material_type_facet") val materialTypeFacet: String?,
    @SerialName("multimedia") val multimedia: List<NewsDetailMedia?>?,
    @SerialName("org_facet") val orgFacet: List<String?>?,
    @SerialName("per_facet") val perFacet: List<String?>?,
    @SerialName("published_date") val publishedDate: String?,
    @SerialName("section") val section: String?,
    @SerialName("short_url") val shortUrl: String?,
    @SerialName("subsection") val subsection: String?,
    @SerialName("title") val title: String?,
    @SerialName("updated_date") val updatedDate: String?,
    @SerialName("uri") val uri: String?,
    @SerialName("url") val url: String?
)

@Keep
@Serializable
data class NewsDetailMedia(
    @SerialName("caption") val caption: String?,
    @SerialName("copyright") val copyright: String?,
    @SerialName("format") val format: String?,
    @SerialName("height") val height: Int?,
    @SerialName("subtype") val subtype: String?,
    @SerialName("type") val type: String?,
    @SerialName("url") val url: String?,
    @SerialName("width") val width: Int?
)