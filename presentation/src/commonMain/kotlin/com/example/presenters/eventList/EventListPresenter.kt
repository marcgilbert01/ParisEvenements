package com.example.presenters.eventList

import com.example.domain.events.entity.Event
import com.example.domain.events.usecase.GetEventsListUseCase
import com.nowtv.domain.common.BaseMapperToPresentation

class EventListPresenter(
    private val view:EventListContract.View,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val eventToEventItemUiModelConverter: BaseMapperToPresentation<Event, EventListContract.EventItemUiModel>
) : EventListContract.Presenter() {

    override suspend fun onStart() {
        TODO("Not yet implemented")
    }

    override suspend fun doInvalidate() {
        TODO("Not yet implemented")
    }
}