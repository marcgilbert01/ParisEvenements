package com.example.domain.events.repository

import com.example.domain.events.entity.Event
import com.example.domain.events.usecase.GetEventsListUseCase

interface EventsRepo {
    suspend fun getEventsFor(city: GetEventsListUseCase.City): List<Event>
}