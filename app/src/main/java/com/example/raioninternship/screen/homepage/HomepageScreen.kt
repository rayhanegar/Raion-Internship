package com.example.raioninternship.screen.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.R
import com.example.raioninternship.databinding.ScreenHomepageBinding

class HomepageScreen : Fragment() {

    private var _binding : ScreenHomepageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ScreenHomepageBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        binding.ivProjectBanner1.setOnClickListener(){
            navController.navigate(R.id.projectDetail)
        }

        return view
    }


}