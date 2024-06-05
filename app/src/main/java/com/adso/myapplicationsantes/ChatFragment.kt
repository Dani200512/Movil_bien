package com.adso.myapplicationsantes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adso.myapplicationsantes.adapter.ContactsAdapter


class ChatFragment : Fragment() {


    lateinit var contactsRecyclerView: RecyclerView
    private val contactsList = mutableListOf<Contact>()
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactsRecyclerView = view.findViewById(R.id.contactsRecyclerView) // Initialize RecyclerView
        initContactsList()
        initRecyclerView()
    }

    private fun initContactsList() {
        val contact1 = Contact(1, "Alvaro Pérez", R.drawable.nino)
        val contact2 = Contact(2, "Karina Carvajal", R.drawable.chico)
        val contact3 = Contact(3, "Daniela Alpala", R.drawable.mujer)
        val contact4 = Contact(4, "Fernando Santes", R.drawable.hombre)
        val contact5 = Contact(5, "Sofia Gómez", R.drawable.nina)
        val contact6 = Contact(6, "Elena Narvaez", R.drawable.perfil)
        val contact7 = Contact(7, "Laura Ramirez", R.drawable.chico)
        val contact8 = Contact(8, "Juan Dias", R.drawable.mujer)
        val contact9 = Contact(9, "Jacob Cifuentes", R.drawable.hombre)
        val contact10= Contact(10,"Maria Jojoa", R.drawable.nina)
        contactsList.addAll(listOf(contact1, contact2, contact3, contact4, contact5, contact6,
            contact7, contact8,contact9, contact10))
    }

    private fun initRecyclerView() {
        contactsAdapter = ContactsAdapter(contactsList, this)
        contactsRecyclerView.layoutManager = LinearLayoutManager(context)
        contactsRecyclerView.adapter = contactsAdapter
    }

    fun onContactClick(contact: Contact) {
        val intent = Intent(activity, Chat2::class.java)
        intent.putExtra("contactId", contact.id)
        startActivity(intent)
    }
}