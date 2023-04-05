package com.example.raioninternship.screen.projectapply

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.databinding.ScreenProjectApplyBinding


class ProjectApplyScreen : Fragment() {

    private var _binding: ScreenProjectApplyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ScreenProjectApplyBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        return view
    }

}