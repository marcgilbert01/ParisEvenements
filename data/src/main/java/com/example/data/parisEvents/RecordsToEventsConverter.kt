package com.example.data.parisEvents

import com.example.domain.events.entity.Event
import com.nowtv.domain.common.BaseMapperToDomain

class RecordsToEventsConverter : BaseMapperToDomain<Record, Event>() {

    companion object {
        const val TITLE_FIELD_NAME = "title"
        const val LEAD_TEXT_FIELD_NAME = "lead_text"
        const val DESCRIPTION_FIELD_NAME = "description"
    }

    override fun mapToDomain(toBeTransformed: Record): Event {
        return Event(
            title = toBeTransformed.fields[TITLE_FIELD_NAME] as String,
            summary = toBeTransformed.fields[LEAD_TEXT_FIELD_NAME] as String,
            description = toBeTransformed.fields[DESCRIPTION_FIELD_NAME] as String
        )
    }
}