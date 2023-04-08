package com.example.raioninternship.screen.sign

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.raioninternship.data.Repository
import com.example.raioninternship.databinding.ScreenChangePasswordBinding

class ChangePasswordScreen : Fragment() {

    private lateinit var binding: ScreenChangePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ScreenChangePasswordBinding.inflate(layoutInflater)
        val view = binding.root
        val repo = Repository()

        binding.backwhite.setOnClickListener {
            val intent = Intent(requireActivity(), SignInScreen::class.java)
            startActivity(intent)
        }

        return view
    }
}