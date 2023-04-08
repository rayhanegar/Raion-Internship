package com.example.raioninternship.screen.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.R
import com.example.raioninternship.databinding.ScreenSplashscreenBinding

class SplashScreen : Fragment() {

    private var _binding: ScreenSplashscreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ScreenSplashscreenBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        binding.actSplashScreen.alpha = 0f
        binding.actSplashScreen.animate().setDuration(1500).alpha(1f).withEndAction(){
            navController.navigate(R.id.signUpScreen)
            activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        return view
    }

}