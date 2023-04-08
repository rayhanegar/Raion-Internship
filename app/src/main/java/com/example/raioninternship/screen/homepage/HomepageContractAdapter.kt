package com.example.raioninternship.screen.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.raioninternship.databinding.ItemContractBinding

class HomepageContractAdapter (var projectNames : List<String>) : RecyclerView.Adapter<HomepageContractAdapter.HomepageContractViewHolder>() {

    inner class HomepageContractViewHolder (val binding: ItemContractBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomepageContractViewHolder {
        val binding = ItemContractBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomepageContractViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomepageContractViewHolder, position: Int) {
        with(holder){
            with(projectNames[position]){
                binding.tvProjectName.text = this
            }
        }
    }

    override fun getItemCount(): Int {
        return projectNames.size
    }
}