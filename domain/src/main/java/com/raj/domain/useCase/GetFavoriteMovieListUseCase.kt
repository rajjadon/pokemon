package com.raj.domain.useCase

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.DataState
import com.raj.common.error.HttpRequestError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

//class GetFavoriteMovieListUseCase @Inject constructor(private val localRepo: LocalRepo) :
//    BaseUseCase<Unit, List<TrendingDomain>>() {
//    override suspend fun run(
//        params: Unit,
//        scope: CoroutineScope
//    ): Flow<DataState<List<TrendingDomain>>> = flow {
//        try {
//            localRepo.getAllMovie().onEach {
//                emit(DataState.Success(it))
//            }.launchIn(scope)
//        } catch (e: Exception) {
//            emit(
//                DataState.Error(
//                    HttpRequestError.SomeThingWentWrong(
//                        code = 0,
//                        errorMessage = e.message.toString()
//                    )
//                )
//            )
//        }
//    }
//}