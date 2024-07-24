package com.raj.domain.useCase

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.DataState
import com.raj.domain.model.TrendingDomain
import com.raj.domain.repo.RemoteRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val remoteRepo: RemoteRepo) :
    BaseUseCase<Unit, List<TrendingDomain>>() {
    override suspend fun run(
        params: Unit,
        scope: CoroutineScope
    ): Flow<DataState<List<TrendingDomain>>> {
        return remoteRepo.getMovieList()
    }
}