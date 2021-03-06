package com.example.ui.parisEvents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baseandroidapp.R
import com.example.presenters.eventList.EventListContract

class ParisEventListAdapter : RecyclerView.Adapter<ParisEventListAdapter.ViewHolder>() {

    private var eventList = emptyList<EventListContract.EventItemUiModel>()
    var onItemClicked: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.paris_event_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = eventList[position].title
        holder.summaryTextView.text = eventList[position].summary
        holder.categoryTextView.text = eventList[position].category
        holder.addressTextView.text = eventList[position].address
        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    fun update(eventList: List<EventListContract.EventItemUiModel>) {
        this.eventList = eventList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTextView = view.findViewById<TextView>(R.id.title)
        val summaryTextView = view.findViewById<TextView>(R.id.summary)
        val categoryTextView = view.findViewById<TextView>(R.id.category)
        val addressTextView = view.findViewById<TextView>(R.id.address)
    }
}