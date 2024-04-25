package com.geekpastor.quotesapp.Data.Repository

import com.geekpastor.quotesapp.Data.DataSource.QuotesApi
import com.geekpastor.quotesapp.util.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuotesRepository @Inject constructor(
    private val api: QuotesApi
) {

    suspend fun getQuotes() = flow{
        emit(Result.Loading())
        val quotes = api.getQuotes().body()?.quotes
        emit(Result.Success(quotes))
    }.catch {e->
        emit(Result.Error(e.message!!))
    }
}