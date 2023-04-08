package com.example.raioninternship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.raioninternship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.splashScreen4 || destination.id == R.id.viewPagerFragment
                || destination.id == R.id.signUpScreen || destination.id == R.id.signInScreen) {
                binding.bottomNavigationView.visibility = View.INVISIBLE
            } else {
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

    }
}