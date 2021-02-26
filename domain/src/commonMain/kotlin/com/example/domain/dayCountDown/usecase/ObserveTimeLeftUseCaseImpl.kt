package com.example.domain.dayCountDown.usecase

import com.example.domain.dayCountDown.entity.TimeLeft
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObserveTimeLeftUseCaseImpl(
    private val currentTimeUseCase: ObserveCurrentTimeUseCase
) : ObserveTimeLeftUseCase {

    override suspend fun exeUseCase(params: ObserveTimeLeftUseCase.Params): Flow<TimeLeft> {
        return currentTimeUseCase.exeUseCase()
            .map { currentTimeInMillis ->
                val timeLeftInMillis = params.dueDateInMillis - currentTimeInMillis
                val timeLeftInSeconds = timeLeftInMillis / 1000
                TimeLeft(
                    milliSeconds = timeLeftInMillis,
                    seconds = timeLeftInSeconds)
            }
    }
}