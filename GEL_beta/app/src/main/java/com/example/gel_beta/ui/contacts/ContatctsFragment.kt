package com.example.gel_beta.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ContatctsFragment : Fragment() {

    private lateinit var contactsViewModel: ContactsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsViewModel =
            ViewModelProvider(this).get(ContactsViewModel::class.java)

        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}