package com.example.gel_beta.ui.user_information

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gel_beta.MainActivity
import com.example.gel_beta.R
import kotlinx.android.synthetic.main.fragment_user.view.*

class UserFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        if(MainActivity.Name == ""){
            val nextIntent = Intent(context, UserSettingActivity::class.java)
            startActivity(nextIntent)
        }else{
            view.textViewName.text = MainActivity.Name
            view.textViewNationality.text = MainActivity.Nationality
            view.textViewPassportNumber.text = MainActivity.PassPortNo
            view.textViewEmergencyContactsA.text = MainActivity.EmergencyContactA
            view.textViewEmergencyContactsB.text = MainActivity.EmergencyContactB

            view.edit_btn.setOnClickListener {
                val nextIntent = Intent(context, UserSettingActivity::class.java)
                startActivity(nextIntent)
            }
        }

        return view
    }
}