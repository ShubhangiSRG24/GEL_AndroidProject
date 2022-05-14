package com.example.gel_beta.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}