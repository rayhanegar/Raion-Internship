package com.example.raioninternship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.raioninternship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //INI ADALAH PERUBAHAN DARI BRANCH LYRA
        print("INI BERUBAH")

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