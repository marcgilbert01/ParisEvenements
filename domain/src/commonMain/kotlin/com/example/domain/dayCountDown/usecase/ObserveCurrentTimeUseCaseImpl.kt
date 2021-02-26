package com.example.domain.dayCountDown.usecase

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import systemCurrentTimeMillis

class ObserveCurrentTimeUseCaseImpl : ObserveCurrentTimeUseCase {

    companion object {
        const val INTERVAL_IN_MILLIS = 500L
    }

    override suspend fun exeUseCase(): Flow<Long> {
        return flow {
            while (currentCoroutineContext().isActive) {
                this.emit(systemCurrentTimeMillis())
                delay(INTERVAL_IN_MILLIS)
            }
        }
    }
}