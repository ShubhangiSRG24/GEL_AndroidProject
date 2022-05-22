package com.example.gel_beta.ui.home

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gel_beta.MyApp
import com.example.gel_beta.R
import java.net.URL

class VersionAdapter(val versionList: List<Versions>) :
    RecyclerView.Adapter<VersionAdapter.VersionVH>(){
        class VersionVH(itemView: View) : RecyclerView.ViewHolder(itemView){
            var codeNameTxt : TextView = itemView.findViewById(R.id.code_name)
            var descriptionTxt : TextView = itemView.findViewById(R.id.description)
            var drugImg : ImageView = itemView.findViewById(R.id.medicineImage)
            var linearLayout : LinearLayout = itemView.findViewById(R.id.linearLayout)
            var expandableLayout : RelativeLayout = itemView.findViewById(R.id.expendable_layout)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return VersionVH(view)
    }

    override fun onBindViewHolder(holder: VersionVH, position: Int) {

        val versions : Versions = versionList[position]

        holder.codeNameTxt.text = versions.codeName
        holder.descriptionTxt.text = versions.description
        holder.drugImg.setImageDrawable(ContextCompat.getDrawable(MyApp.applicationContext(), versions.image))

        val isExpandable : Boolean = versionList[position].expandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener{
            val versions = versionList[position]
            versions.expandable = !versions.expandable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return versionList.size
    }

}