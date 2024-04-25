package com.geekpastor.quotesapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geekpastor.quotesapp.Data.Repository.QuotesRepository
import com.geekpastor.quotesapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: QuotesRepository
) : ViewModel(){
    val uiState = mutableStateOf(UiState())

    init {
        getNotes()
    }

    fun getNotes(){
        viewModelScope.launch {
            repository.getQuotes().collect{result->
                when(result){
                    is Result.Loading->{
                        uiState.value = UiState(isLoading = true)
                    }

                    is Result.Success->{
                        uiState.value = UiState(isLoading = false, quotes = result.data!!)
                    }

                    is Result.Error -> {
                        uiState.value = UiState(error = result.message)
                    }
                }
            }
        }
    }
}