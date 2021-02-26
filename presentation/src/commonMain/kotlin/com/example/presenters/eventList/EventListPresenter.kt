package com.example.presenters.eventList

import com.example.domain.events.entity.Event
import com.example.domain.events.usecase.GetEventsListUseCase
import com.nowtv.domain.common.BaseMapperToPresentation

class EventListPresenter(
    private val view:EventListContract.View,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val eventToEventItemUiModelConverter: BaseMapperToPresentation<Event, EventListContract.EventItemUiModel>
) : EventListContract.Presenter() {

    private val viewModel = ViewModel()

    override suspend fun onStart() {
        viewModel.loadingSpinnerOn = true
        invalidate()
        getEventsListUseCase.exeUseCase(GetEventsListUseCase.Params(GetEventsListUseCase.City.PARIS)).let {
            viewModel.loadingSpinnerOn = false
            viewModel.eventListItem = eventToEventItemUiModelConverter.mapToPresentation(it)
            invalidate()
        }
    }

    override suspend fun doInvalidate() {
        view.displayEventList(viewModel.eventListItem)
    }

    private class ViewModel {
        var loadingSpinnerOn = false
        var eventListItem = listOf<EventListContract.EventItemUiModel>()
    }
}