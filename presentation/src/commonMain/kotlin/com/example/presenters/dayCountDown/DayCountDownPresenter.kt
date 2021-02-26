package com.example.presenters.dayCountDown

import com.example.domain.dayCountDown.usecase.ObserveTimeLeftUseCase
import kotlinx.coroutines.flow.collect

class DayCountDownPresenter(
    private val view: DayCountDownContract.View,
    private val observeTimeLeftUseCase: ObserveTimeLeftUseCase
) : DayCountDownContract.Presenter() {

    companion object {
        const val dueDateFirstJanTwentyFifty = 2524608000000
    }

    private var viewModel = ViewModel()

    override suspend fun onStart() {
        observeTimeLeftUseCase.exeUseCase(ObserveTimeLeftUseCase.Params(dueDateFirstJanTwentyFifty))
            .collect {
                viewModel.secondsLeftBeforeDueDate = it.seconds.toString()
                invalidate()
            }
    }

    override suspend fun doInvalidate() {
        view.displayDueDate(viewModel.dueDate)
        view.displaySecondsLeftBeforeDueDate(viewModel.secondsLeftBeforeDueDate)
    }

    private class ViewModel {
        var secondsLeftBeforeDueDate: String? = null
        var dueDate: String? = null
    }
}