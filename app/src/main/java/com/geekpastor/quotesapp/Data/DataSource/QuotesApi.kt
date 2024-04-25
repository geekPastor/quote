package com.geekpastor.quotesapp.Data.DataSource

import com.geekpastor.quotesapp.Domaine.model.QuotesResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>
}