package com.example.domain.events.entity

data class Event (
    val eventId: String,
    val title: String?,
    val summary: String?,
    val description: String?,
    val address: String?,
    val category: String?,
    val imageUrl: String?
)