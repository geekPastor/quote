package com.geekpastor.quotesapp.Domaine.model

data class QuotesResponse(
    val quotes: List<Quote>,
    val total: Int
)
