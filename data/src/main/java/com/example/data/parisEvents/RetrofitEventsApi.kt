package com.example.data.parisEvents

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitEventsApi {

    @GET("/api/records/1.0/search/?dataset=que-faire-a-paris-")
    fun getEvents(): Call<EventListData>
}