package com.example.raioninternship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.raioninternship.databinding.ActivityMainBinding
import com.example.raioninternship.screen.onboarding.OnboardingScreen
import com.example.raioninternship.screen.sign.SignUpScreen

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentContainer = binding.fragmentContainerView

//        fragmentContainer.findNavController().addOnDestinationChangedListener(object: NavController.OnDestinationChangedListener{
//            override fun onDestinationChanged(
//                controller: NavController,
//                destination: NavDestination,
//                arguments: Bundle?
//            ) {
//                if (destination.id == R.layout.screen_splashscreen){
//
//                } else {
//
//                }
//            }
//        })

    }
}