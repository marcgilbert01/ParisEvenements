package net.freshclouds.recipes.presentation.common

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

abstract class BasePresenter {

    private var job: Job? = null

    fun onViewStart() {
        CoroutineScope(Dispatchers.Default).launch {
            onStart()
        }.also {
            job = it
        }
    }

    protected abstract suspend fun onStart()

    suspend fun invalidate() = withContext(Dispatchers.Main) {
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
