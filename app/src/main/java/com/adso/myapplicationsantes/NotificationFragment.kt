package com.adso.myapplicationsantes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adso.myapplicationsantes.adapter.NotificationAdapter

class NotificationFragment : Fragment() {

    private val notifications = mutableListOf<Notification>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadNotifications()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = NotificationAdapter(notifications)

        view.findViewById<TextView>(R.id.mark_as_read).setOnClickListener {
            markAllAsRead()
        }
    }

    private fun loadNotifications() {
        for (i in 1..6) {
            notifications.add(
                Notification(
                    R.drawable.perfil,
                    "tienes una nueva oferta de trabajo",
                    "1/ago",
                    i <= 2
                )
            )
        }
        for (i in 1..6) {
            notifications.add(
                Notification(
                    R.drawable.usuario2,
                    "tienes un nuevo vacante para la oferta de trabajo",
                    "4/nov",
                    i <= 2
                )
            )
        }
    }

    private fun markAllAsRead() {
        notifications.forEach { it.isUnread = false }
        view?.findViewById<RecyclerView>(R.id.recycler_view)?.adapter?.notifyDataSetChanged()
    }
}