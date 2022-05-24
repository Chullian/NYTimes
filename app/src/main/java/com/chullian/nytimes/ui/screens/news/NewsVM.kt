package com.chullian.nytimes.ui.screens.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chullian.nytimes.data.network.NewsSections
import com.chullian.nytimes.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by binMammootty on 24/05/2022.
 */
@HiltViewModel
class NewsVM @Inject constructor(
    private val repository: NewsRepository
):ViewModel() {

    private val viewModelState = MutableStateFlow(NewsVMState(isLoading = true))

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        getSections()
    }

    fun getSections() = viewModelScope.launch {
        val sections = listOf(
            NewsSections.Arts,
            NewsSections.Automobiles,
            NewsSections.Books,
            NewsSections.Business,
            NewsSections.Fashion,
            NewsSections.Food,
            NewsSections.Health,
            NewsSections.Home,
            NewsSections.Insider,
            NewsSections.Magazine,
            NewsSections.Movies,
            NewsSections.Obituaries,
            NewsSections.Opinion,
            NewsSections.Politics,
            NewsSections.RealEstate,
            NewsSections.Science,
            NewsSections.Sports,
            NewsSections.SundayReview,
            NewsSections.Technology,
            NewsSections.Theater,
            NewsSections.Tmagazine,
            NewsSections.Travel,
            NewsSections.Upshot,
            NewsSections.Us,
            NewsSections.World
        )
        viewModelState.update {
            it.copy(newsSections = sections)
        }
    }

//    fun getHeadlines() = viewModelScope.launch {
//        repository.fetchSectionDetail()
//    }
}