package com.example.ui.parisEvents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseandroidapp.R
import com.example.data.parisEvents.EventsRepoImpl
import com.example.data.parisEvents.RecordsToEventsConverter
import com.example.domain.events.usecase.GetEventsListUseCaseImpl
import com.example.presenters.eventList.EventListContract
import com.example.presenters.eventList.EventListPresenter
import com.example.presenters.eventList.EventToEventItemUiModelConverter

class ParisEventListActivity : AppCompatActivity(), EventListContract.View {

    private var presenter: EventListContract.Presenter? = null
    private var adapter: ParisEventListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paris_event_list)
        presenter = EventListPresenter(
            view = this,
            getEventsListUseCase = GetEventsListUseCaseImpl(
                eventsRepo = EventsRepoImpl(
                    recordsToEventsConverter = RecordsToEventsConverter())),
            eventToEventItemUiModelConverter = EventToEventItemUiModelConverter()
        )
        findViewById<RecyclerView>(R.id.event_list_recyclerView)?.let { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(this)
            ParisEventListAdapter().let { eventAdapter ->
                adapter = eventAdapter
                recyclerView.adapter = eventAdapter
                eventAdapter.onItemClicked = { position ->
                    presenter?.onItemClicked(position)
                }
            }
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

    override fun displayEventList(eventListUiModels: List<EventListContract.EventItemUiModel>) {
        adapter?.update(eventListUiModels)
    }

    override fun navigateToEvenDetail(eventId: String) {
        val intent = Intent(this, ParisEventDetailActivity::class.java)
        intent.putExtra(ParisEventDetailActivity.EVENT_ID_PARAM, eventId)
        startActivity(intent)
    }
}