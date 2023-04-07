package com.example.raioninternship.screen.homepage.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.R
import com.example.raioninternship.databinding.FragmentHomepageBanner3Binding

class HomepageBanner3 : Fragment() {

    private var _binding: FragmentHomepageBanner3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomepageBanner3Binding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        binding.ivCardBanner.setOnClickListener(){

        }
        return view
    }

}