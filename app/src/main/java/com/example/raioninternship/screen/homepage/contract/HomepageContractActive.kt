package com.example.raioninternship.screen.homepage.contract

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raioninternship.databinding.FragmentHomepageContractActiveBinding
import com.example.raioninternship.screen.homepage.HomepageContractAdapter


class HomepageContractActive : Fragment() {

    private var _binding : FragmentHomepageContractActiveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomepageContractActiveBinding.inflate(inflater, container, false)
        val view = binding.root

        val projectNames = listOf<String>(
            "Luxe Project - Web Dev.",
            "Maju Group - FE Product",
            "Artemis - Orion Project",
            "Volunteer.id - Web Dev."
        )

        val adapter = HomepageContractAdapter(projectNames)
        binding.rvContract.adapter = adapter
        binding.rvContract.layoutManager = LinearLayoutManager(this.context)

        return view
    }

}