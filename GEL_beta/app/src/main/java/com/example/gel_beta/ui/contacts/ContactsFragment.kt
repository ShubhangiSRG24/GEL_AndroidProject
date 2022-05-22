package com.example.gel_beta.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gel_beta.R
import android.content.Intent
import android.net.Uri
import com.example.gel_beta.ui.home.MapsActivity

class ContactsFragment : Fragment(), View.OnClickListener{

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_contacts, container, false);

        val contactA: Button = view.findViewById(R.id.btn_contact_a)
        contactA.setOnClickListener(this)

        val contactB: Button = view.findViewById(R.id.btn_contact_b)
        contactB.setOnClickListener(this)

        val contactC: Button = view.findViewById(R.id.btn_contact_c)
        contactC.setOnClickListener(this)

        val contactD: Button = view.findViewById(R.id.btn_contact_d)
        contactD.setOnClickListener(this)

        val contactE: Button = view.findViewById(R.id.btn_contact_e)
        contactE.setOnClickListener(this)

        val contactF: Button = view.findViewById(R.id.btn_contact_f)
        contactF.setOnClickListener(this)

        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_contact_a -> {
                var nextIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://english.visitkorea.or.kr/enu/index.kto"))
                startActivity(nextIntent)
            }
            R.id.btn_contact_b -> {
                var nextIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hikorea.go.kr/mobile/mMain.pt?locale=en"))
                startActivity(nextIntent)
            }
            R.id.btn_contact_c -> {
                var nextIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.liveinkorea.kr/portal/USA/main/main.do"))
                startActivity(nextIntent)
            }
            R.id.btn_contact_d -> {
                var nextIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.humanrights.go.kr/site/main/index002"))
                startActivity(nextIntent)
            }
            R.id.btn_contact_e -> {
                var nextIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.police.go.kr/tourPol/engMain.do"))
                startActivity(nextIntent)
            }
            R.id.btn_contact_f -> {
                var nextIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lost112.go.kr/manyLanguage.do?langType=en"))
                startActivity(nextIntent)
            }
        }
    }
}