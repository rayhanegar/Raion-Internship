package com.example.raioninternship.screen.kiat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.raioninternship.MainActivity
import com.example.raioninternship.databinding.ScreenKiatIt2Binding

class Kiat2Screen : Fragment() {

    private lateinit var binding : ScreenKiatIt2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnback.setOnClickListener{
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}