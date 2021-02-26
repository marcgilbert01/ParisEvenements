package com.example.domain.events.usecase

import com.example.domain.events.entity.Event
import com.example.domain.events.repository.EventsRepo

class GetEventsListUseCaseImpl(
    private val eventsRepo: EventsRepo
) : GetEventsListUseCase {

    override suspend fun exeUseCase(params: GetEventsListUseCase.Params): List<Event> {
        return eventsRepo.getEventsFor(params.city)
    }
}