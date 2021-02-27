package com.example.presenters.eventList

import net.freshclouds.recipes.presentation.common.BasePresenter

interface EventListContract {

    interface View {
        fun displayEventList(eventListUiModels: List<EventItemUiModel>)
        fun navigateToEvenDetail(eventId: String)
    }

    abstract class Presenter: BasePresenter() {
        abstract fun onItemClicked(position: Int)
    }

    data class EventItemUiModel(
        val title: String?,
        val summary: String?,
        val category: String?,
        val address: String?
    )
}