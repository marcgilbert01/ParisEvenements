package com.example.domain.dayCountDown.usecase

import com.example.domain.dayCountDown.entity.TimeLeft
import com.nowtv.domain.common.UseCase
import kotlinx.coroutines.flow.Flow

interface ObserveTimeLeftUseCase : UseCase<Flow<TimeLeft>, ObserveTimeLeftUseCase.Params> {

    override suspend fun exeUseCase(params: Params): Flow<TimeLeft>

    data class Params(val dueDateInMillis: Long)
}