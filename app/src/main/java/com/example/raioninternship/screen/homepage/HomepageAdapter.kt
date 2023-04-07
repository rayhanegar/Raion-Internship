package com.example.raioninternship.screen.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.raioninternship.R

class HomepageAdapter(private val fragmentList: ArrayList<Fragment>) : RecyclerView.Adapter<HomepageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_homepage, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fragment = fragmentList[position]
        holder.bind(fragment)
    }

    override fun getItemCount() = fragmentList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(fragment: Fragment) {
            val container = itemView.findViewById<FrameLayout>(R.id.flContainer)
            val fragmentManager = (itemView.context as FragmentActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(container.id, fragment)
                .commit()
        }
    }
}
