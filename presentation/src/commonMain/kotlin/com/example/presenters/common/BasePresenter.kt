package net.freshclouds.recipes.presentation.common

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

abstract class BasePresenter {

    companion object {
        var mainDispatcher: CoroutineDispatcher = Dispatchers.Main
        var defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
    }
    private var job: Job? = null

    fun onViewStart() {
        CoroutineScope(defaultDispatcher).launch {
            onStart()
        }.also {
            job = it
        }
    }

    protected abstract suspend fun onStart()

    suspend fun invalidate() = withContext(mainDispatcher) {
        doInvalidate()
    }

    protected abstract suspend fun doInvalidate()

    fun onViewStop() {
        job?.cancel()
    }

    fun onViewDestroyed() {
        job?.cancel()
    }
}
