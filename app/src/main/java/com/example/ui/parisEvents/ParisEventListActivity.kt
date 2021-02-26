package com.example.ui.parisEvents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseandroidapp.R
import com.example.data.parisEvents.EventsRepoImpl
import com.example.data.parisEvents.RecordsToEventsConverter
import com.example.domain.events.usecase.GetEventsListUseCase
import com.example.domain.events.usecase.GetEventsListUseCaseImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ParisEventListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paris_event_list)


        val getEventsListUseCase = GetEventsListUseCaseImpl(
            eventsRepo = EventsRepoImpl(
                recordsToEventsConverter = RecordsToEventsConverter()
            )
        )

        GlobalScope.launch {
            getEventsListUseCase.exeUseCase(GetEventsListUseCase.Params(GetEventsListUseCase.City.PARIS)).let {
                println("marc "+ it[0].title)
            }
        }
    }
}