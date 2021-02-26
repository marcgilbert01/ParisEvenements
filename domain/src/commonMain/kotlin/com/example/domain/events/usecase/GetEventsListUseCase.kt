package com.example.domain.events.usecase

import com.example.domain.events.entity.Event
import com.nowtv.domain.common.UseCase

interface GetEventsListUseCase : UseCase<List<Event>, GetEventsListUseCase.Params> {

    data class Params(val city: City)

    enum class City {
        PARIS
    }
}