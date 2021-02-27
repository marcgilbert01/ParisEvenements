package com.example.domain.dayCountDown.usecase

import com.example.domain.common.UseCaseVoid
import kotlinx.coroutines.flow.Flow

interface ObserveCurrentTimeUseCase : UseCaseVoid<Flow<Long>> {

    override suspend fun exeUseCase(): Flow<Long>
}