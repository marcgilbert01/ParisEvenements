package com.example.presenters.eventList

import net.freshclouds.recipes.presentation.common.BasePresenter

interface EventListContract {

    interface View {
        fun displayEventList(eventListUiModels: List<EventItemUiModel>)
    }

    abstract class Presenter: BasePresenter()

    data class EventItemUiModel(
        val title: String,
        val summary: String
    )
}