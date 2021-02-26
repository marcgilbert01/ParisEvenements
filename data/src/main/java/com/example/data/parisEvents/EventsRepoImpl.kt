package com.example.data.parisEvents

import com.example.domain.events.entity.Event
import com.example.domain.events.repository.EventsRepo
import com.example.domain.events.usecase.GetEventsListUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsRepoImpl(
    private val recordsToEventsConverter: RecordsToEventsConverter
) : EventsRepo {

    companion object {
        const val URL = "https://opendata.paris.fr"
    }

    override suspend fun getEventsFor(city: GetEventsListUseCase.City): List<Event> {

        val response = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitEventsApi::class.java)
            .getEvents()
            .execute()

        response.body()?.let {
            return recordsToEventsConverter.mapToDomain(it.records.toList())
        }

        return emptyList()
    }

}