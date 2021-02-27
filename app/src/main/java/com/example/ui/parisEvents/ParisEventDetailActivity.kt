package com.example.ui.parisEvents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.baseandroidapp.R
import com.example.data.parisEvents.EventsRepoImpl
import com.example.data.parisEvents.RecordsToEventsConverter
import com.example.domain.events.usecase.GetEventsListUseCaseImpl
import com.example.imageView.PeImageView
import com.example.presenters.eventDetails.EventDetailsContract
import com.example.presenters.eventDetails.EventDetailsPresenter

class ParisEventDetailActivity : AppCompatActivity(), EventDetailsContract.View {

    companion object {
        const val EVENT_ID_PARAM = "EVENT_ID_PARAM"
    }

    private var presenter: EventDetailsContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paris_event_detail)
        intent.getStringExtra(EVENT_ID_PARAM)?.let { eventId ->
            presenter = EventDetailsPresenter(
               view = this,
               getEventsListUseCase = GetEventsListUseCaseImpl(
                   eventsRepo = EventsRepoImpl(
                       recordsToEventsConverter = RecordsToEventsConverter())),
               eventId = eventId
            )
        }
    }

    override fun onStart() {
        super.onStart()
        presenter?.onViewStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onViewStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onViewDestroyed()
    }

    override fun displayImage(url: String?) {
        url?.let {
            findViewById<PeImageView>(R.id.image).setImageUrl(it)
        }
    }

    override fun displayTitle(title: String?) {
        findViewById<TextView>(R.id.title).text = title
    }

    override fun displayCategory(category: String?) {
        findViewById<TextView>(R.id.category).text = category
    }

    override fun displayAddress(address: String?) {
        findViewById<TextView>(R.id.address).text = address
    }

    override fun displayDescription(description: String?) {
        findViewById<TextView>(R.id.description).text = description
    }
}