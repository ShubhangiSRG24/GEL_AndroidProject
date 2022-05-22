package com.example.gel_beta.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gel_beta.R

class UserFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false);

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}