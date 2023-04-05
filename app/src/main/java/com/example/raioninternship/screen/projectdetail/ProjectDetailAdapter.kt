package com.example.raioninternship.screen.projectdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.raioninternship.databinding.ItemProjectDetailBinding

class ProjectDetailAdapter (var projectFields : List<String>, var projectRecords : List<String> ) : RecyclerView.Adapter<ProjectDetailAdapter.ProjectDetailViewHolder>(){

    inner class ProjectDetailViewHolder (val binding: ItemProjectDetailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectDetailViewHolder {
        val binding = ItemProjectDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectDetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return projectRecords.size
    }

    override fun onBindViewHolder(holder: ProjectDetailViewHolder, position: Int) {
        with(holder){
            with(projectFields[position]){
                binding.tvCardHeader.text = this
            }
            with (projectRecords[position]){
                binding.tvCardContent.text = this
            }
        }
    }


}