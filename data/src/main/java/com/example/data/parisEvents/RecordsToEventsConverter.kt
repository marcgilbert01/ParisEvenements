package com.example.data.parisEvents

import com.example.domain.events.entity.Event
import com.example.domain.common.BaseMapperToDomain

class RecordsToEventsConverter : BaseMapperToDomain<Record, Event>() {

    companion object {
        const val TITLE_FIELD_NAME = "title"
        const val LEAD_TEXT_FIELD_NAME = "lead_text"
        const val DESCRIPTION_FIELD_NAME = "description"
        const val ADDRESS_NAME_FIELD_NAME = "address_name"
        const val CATEGORY_NAME_FIELD_NAME = "category"
    }

    override fun mapToDomain(toBeTransformed: Record): Event {
        return Event(
            eventId = toBeTransformed.recordid,
            title = toBeTransformed.fields[TITLE_FIELD_NAME] as String,
            summary = toBeTransformed.fields[LEAD_TEXT_FIELD_NAME] as String,
            description = toBeTransformed.fields[DESCRIPTION_FIELD_NAME] as String,
            address = toBeTransformed.fields[ADDRESS_NAME_FIELD_NAME] as String,
            category = toBeTransformed.fields[CATEGORY_NAME_FIELD_NAME] as String
        )
    }
}