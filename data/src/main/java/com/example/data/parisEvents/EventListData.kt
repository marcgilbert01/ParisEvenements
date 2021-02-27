package com.example.data.parisEvents

class EventListData (
    val records: Array<Record>
)

class Record (
    val recordid: String,
    val fields: Map<String, Any>
)