package com.example.raioninternship.screen.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.raioninternship.databinding.ScreenSigninBinding
import com.example.raioninternship.databinding.ScreenSignupBinding

class SignInScreen : Fragment() {

    private lateinit var binding: ScreenSigninBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenSigninBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }
}