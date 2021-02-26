package com.example.presenters.dayCountDown

import net.freshclouds.recipes.presentation.common.BasePresenter

interface DayCountDownContract {

    interface View {
        fun displayDueDate(string: String?)
        fun displaySecondsLeftBeforeDueDate(string: String?)
    }

    abstract class Presenter: BasePresenter()
}