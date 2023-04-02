package com.example.raioninternship.screen.onboarding.onboardingScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.R
import com.example.raioninternship.databinding.FragmentOnboarding4Binding


class Onboarding4 : Fragment() {

    private var _binding : FragmentOnboarding4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentOnboarding4Binding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        binding.btnGetStarted.setOnClickListener(){
            navController.navigate(R.id.homepageScreen)
        }

        return view
    }

}