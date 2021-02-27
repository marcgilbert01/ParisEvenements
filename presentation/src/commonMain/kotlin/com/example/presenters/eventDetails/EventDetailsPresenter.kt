package com.example.presenters.eventDetails

import com.example.domain.events.entity.Event
import com.example.domain.events.usecase.GetEventsListUseCase

class EventDetailsPresenter(
    private val view: EventDetailsContract.View,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val eventId: String
) : EventDetailsContract.Presenter() {

    private var event: Event? = null

    override suspend fun onStart() {
        getEventsListUseCase.exeUseCase(GetEventsListUseCase.Params(GetEventsListUseCase.City.PARIS)).let { eventList ->
            findEventId(eventList)?.let {
                event = it
                invalidate()
            }
        }
    }

    private fun findEventId(eventList: List<Event>): Event? {
        for (event in eventList) {
            if (eventId == event.eventId) {
                return event
            }
        }
        return null
    }

    override suspend fun doInvalidate() {
        event?.let {
            view.displayImage(it.imageUrl)
            view.displayTitle(it.title)
            view.displayCategory(it.category)
            view.displayAddress(it.address)
            view.displayDescription(it.description)
        }
    }
}