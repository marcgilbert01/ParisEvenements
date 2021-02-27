package com.example.presenters.eventList

import com.example.domain.events.entity.Event
import com.example.domain.common.BaseMapperToPresentation

class EventToEventItemUiModelConverter : BaseMapperToPresentation<Event, EventListContract.EventItemUiModel>() {
    override fun mapToPresentation(toBeTransformed: Event): EventListContract.EventItemUiModel {
        return EventListContract.EventItemUiModel(
            title = toBeTransformed.title,
            summary = toBeTransformed.summary,
            category = toBeTransformed.category,
            address = toBeTransformed.address
        )
    }
}