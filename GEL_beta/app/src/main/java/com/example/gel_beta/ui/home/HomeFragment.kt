package com.example.gel_beta.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.gel_beta.R

class HomeFragment : Fragment(), View.OnClickListener{


    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false);

        val emergency_btn: Button = view.findViewById(R.id.emergency_call)
        emergency_btn.setOnClickListener(this)

        val police_call_btn: Button = view.findViewById(R.id.security_call)
        police_call_btn.setOnClickListener(this)

        val medicine_btn: Button = view.findViewById(R.id.emergency_simple)
        medicine_btn.setOnClickListener(this)

        val police_text_btn: Button = view.findViewById(R.id.security_text)
        police_text_btn.setOnClickListener(this)

        val map_btn: Button = view.findViewById(R.id.map)
        map_btn.setOnClickListener(this)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.emergency_call -> {
                val nextIntent = Intent(context, EmergencyCallActivity::class.java)
                startActivity(nextIntent)
            }
            R.id.security_call -> {
                val nextIntent = Intent(context, PoliceCallActivity::class.java)
                startActivity(nextIntent)
            }
            R.id.emergency_simple -> { println("emergency_simple clicked!") }
            R.id.security_text -> { println("security_text clicked!") }
            R.id.map -> {
                val nextIntent = Intent(context, MapsActivity::class.java)
                startActivity(nextIntent)
            }
        }
    }
}