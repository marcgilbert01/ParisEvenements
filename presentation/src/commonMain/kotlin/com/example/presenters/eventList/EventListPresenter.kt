package com.example.presenters.eventList

import com.example.domain.events.entity.Event
import com.example.domain.events.usecase.GetEventsListUseCase
import com.example.domain.common.BaseMapperToPresentation

class EventListPresenter(
    private val view:EventListContract.View,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val eventToEventItemUiModelConverter: BaseMapperToPresentation<Event, EventListContract.EventItemUiModel>
) : EventListContract.Presenter() {

    private val viewModel = ViewModel()
    private var eventList: List<Event>? = null

    override suspend fun onStart() {
        viewModel.loadingSpinnerOn = true
        invalidate()
        getEventsListUseCase.exeUseCase(GetEventsListUseCase.Params(GetEventsListUseCase.City.PARIS)).let {
            eventList = it
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

    override fun onItemClicked(position: Int) {
        eventList?.let {
            view.navigateToEvenDetail(it[position].eventId)
        }
    }
}