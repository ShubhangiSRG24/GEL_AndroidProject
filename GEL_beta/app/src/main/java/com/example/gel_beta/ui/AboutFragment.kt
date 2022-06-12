package com.example.gel_beta.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.gel_beta.R
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment(), View.OnClickListener{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val teamA: Button = view.findViewById(R.id.btn_team_a)
        teamA.setOnClickListener(this)

        val teamB: Button = view.findViewById(R.id.btn_team_b)
        teamB.setOnClickListener(this)

        val material_a: Button = view.findViewById(R.id.btn_about_a)
        material_a.setOnClickListener(this)

        val material_b: Button = view.findViewById(R.id.btn_about_b)
        material_b.setOnClickListener(this)

        val material_c: Button = view.findViewById(R.id.btn_about_c)
        material_c.setOnClickListener(this)

        val material_d: Button = view.findViewById(R.id.btn_about_d)
        material_d.setOnClickListener(this)

        val material_e: Button = view.findViewById(R.id.btn_about_e)
        material_e.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_team_a -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://in.linkedin.com/in/shubhangi-saileja-r-garnaik-95802b12a")
                )
                startActivity(nextIntent)
            }
            R.id.btn_team_b -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/youngchan-lim-748169143/")
                )
                startActivity(nextIntent)
            }
            R.id.btn_about_a -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/YCL-01/project_description/blob/main/GEL%20Formative%20Research.pdf")
                )
                startActivity(nextIntent)
            }
            R.id.btn_about_b -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/file/d/1Mp-tqy-jPj4MVlxhAqCRCA9ebF75WUCB/view?usp=sharing")
                )
                startActivity(nextIntent)
            }
            R.id.btn_about_c -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/YCL-01/project_description/blob/main/GEL%20Mid%20Fidelity%20Report.pdf")
                )
                startActivity(nextIntent)
            }
            R.id.btn_about_d -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/file/d/1F9K3aj8w0ptcc4kc4ZVyE8vQle0aaKYN/view?usp=sharing")
                )
                startActivity(nextIntent)
            }
            R.id.btn_about_e -> {
                var nextIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/file/d/1AhWthUHhubfS_ZXVmAgIUUdt3SZV7DwO/view?usp=sharing")
                )
                startActivity(nextIntent)
            }
        }
    }
}
