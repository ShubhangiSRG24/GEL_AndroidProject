package com.example.gel_beta.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gel_beta.R

class ContatctsFragment : Fragment() {

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View? {




        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}