package com.chullian.nytimes.ui.screens.news

import com.chullian.nytimes.data.NewsFeed
import com.chullian.nytimes.data.model.ErrorMessage
import com.chullian.nytimes.data.network.NewsSections

sealed interface NewsUiState {


   val isLoading: Boolean
   val errorMessages: List<ErrorMessage>
   val searchInput: String
   val newsSections:List<NewsSections>



   data class NoPosts(
      override val isLoading: Boolean,
      override val errorMessages: List<ErrorMessage>,
      override val searchInput: String,
      override val newsSections: List<NewsSections>,
   ) : NewsUiState


   data class HasPosts(
      override val isLoading: Boolean,
      override val errorMessages: List<ErrorMessage>,
      override val searchInput: String,
      override val newsSections: List<NewsSections>,
      val newsFeed: List<NewsFeed>?,
   ) : NewsUiState

}


data class NewsVMState(
   val newsFeed: List<NewsFeed>? = null,
   val newsSections: List<NewsSections> = emptyList(),
   val isLoading: Boolean = false,
   val errorMessages: List<ErrorMessage> = emptyList(),
   val searchInput: String = "",
) {

   /**
    * Converts this [NewsVMState] into a more strongly typed [NewsUiState] for driving
    * the ui.
    */
   fun toUiState(): NewsUiState =
      if (newsFeed == null) {
         NewsUiState.NoPosts(
            newsSections= newsSections,
            isLoading = isLoading,
            errorMessages = errorMessages,
            searchInput = searchInput
         )
      } else {
         NewsUiState.HasPosts(
            newsSections= newsSections,
            newsFeed = newsFeed,
            isLoading = isLoading,
            errorMessages = errorMessages,
            searchInput = searchInput
         )
      }
}