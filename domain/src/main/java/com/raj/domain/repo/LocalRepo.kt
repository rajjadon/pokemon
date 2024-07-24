package com.raj.domain.repo

import com.raj.domain.model.TrendingDomain
import kotlinx.coroutines.flow.Flow

interface LocalRepo {
    suspend fun insert(trendingDomain: TrendingDomain)

    suspend fun deleteAll()

    suspend fun delete(movieId: String)

    fun getAllMovie(): Flow<List<TrendingDomain>>

    suspend fun update(trendingDomain: TrendingDomain)
}