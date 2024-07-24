package com.raj.domain.repo

import com.raj.common.baseClasses.DataState
import com.raj.domain.model.TrendingDomain
import kotlinx.coroutines.flow.Flow

interface RemoteRepo {
    suspend fun getMovieList(): Flow<DataState<List<TrendingDomain>>>
}