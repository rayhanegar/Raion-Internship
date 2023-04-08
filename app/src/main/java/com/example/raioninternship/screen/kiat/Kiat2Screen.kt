package com.example.raioninternship.screen.kiat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.MainActivity
import com.example.raioninternship.R
import com.example.raioninternship.databinding.ScreenKiatIt2Binding

class Kiat2Screen : Fragment() {

    private var _binding : ScreenKiatIt2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ScreenKiatIt2Binding.inflate(inflater, container, false)
        val view = binding.root

        val navController = findNavController()
        binding.btnback.setOnClickListener{
            navController.navigate(R.id.homepageScreen)
        }

        return view
    }
}