package com.example.presenters.eventDetails

import net.freshclouds.recipes.presentation.common.BasePresenter

interface EventDetailsContract {

    interface View {
        fun displayImage(url: String?)
        fun displayTitle(title: String?)
        fun displayCategory(category: String?)
        fun displayAddress(address: String?)
        fun displayDescription(description: String?)
    }

    abstract class Presenter : BasePresenter()
}