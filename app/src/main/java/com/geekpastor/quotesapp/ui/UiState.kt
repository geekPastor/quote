package com.geekpastor.quotesapp.ui

import com.geekpastor.quotesapp.Domaine.model.Quote
import com.geekpastor.quotesapp.util.Result

data class UiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val quotes: List<Quote> = emptyList()
)