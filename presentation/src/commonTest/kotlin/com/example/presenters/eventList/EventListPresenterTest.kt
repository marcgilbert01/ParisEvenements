package com.example.presenters.eventList

import com.example.domain.events.entity.Event
import com.example.domain.events.usecase.GetEventsListUseCase
import com.nowtv.domain.common.BaseMapperToPresentation
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import net.freshclouds.recipes.presentation.common.BasePresenter
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class EventListPresenterTest {

    private lateinit var cut: EventListPresenter

    private val view = mockk<EventListContract.View>(relaxed = true)

    private val getEventsListUseCase = mockk<GetEventsListUseCase>(relaxed = true)

    private val eventToEventItemUiModelListConverter = mockk<BaseMapperToPresentation<Event, EventListContract.EventItemUiModel>>()

    private val eventsList = listOf<Event>()

    private val eventItemUiList = listOf<EventListContract.EventItemUiModel>()

    @BeforeTest
    fun setup() {
        BasePresenter.mainDispatcher = Dispatchers.Unconfined
        BasePresenter.defaultDispatcher = Dispatchers.Unconfined
        cut = EventListPresenter(
            view = view,
            getEventsListUseCase = getEventsListUseCase,
            eventToEventItemUiModelConverter = eventToEventItemUiModelListConverter
        )
        coEvery { getEventsListUseCase.exeUseCase(any()) }.returns(eventsList)
        coEvery { eventToEventItemUiModelListConverter.mapToPresentation(eventsList) }.returns(eventItemUiList)
    }

    @Test
    fun given_list_of_events_when_view_start_then_display_list_of_events() {
        // when
        cut.onViewStart()

        // then
        verify { eventToEventItemUiModelListConverter.mapToPresentation(eventsList) }
        verify { view.displayEventList(eventItemUiList) }
    }
}