package com.example.raioninternship.screen.sign

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.raioninternship.MainActivity
import com.example.raioninternship.data.Repository
import com.example.raioninternship.databinding.ScreenChangePasswordBinding
import com.example.raioninternship.databinding.ScreenSigninBinding

class SignInScreen : Fragment() {

    private lateinit var binding: ScreenSigninBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ScreenSigninBinding.inflate(layoutInflater)
        val view = binding.root
        val repo = Repository()

        binding.signup.setOnClickListener {
            val intent = Intent(requireActivity(), SignUpScreen::class.java)
            startActivity(intent)
        }

        binding.forpasstext.setOnClickListener {
            val changePasswordBinding = ScreenChangePasswordBinding.inflate(layoutInflater)
            repo.changePass(changePasswordBinding)
        }

        binding.btnSignin.setOnClickListener(){
            val email = binding.emailEditText.text.toString()
            val pass = binding.passEditText.text.toString()
            val isSeeker = binding.btnSeeker.isSelected
            val isClient = binding.btnClient.isSelected

            if (isSeeker || isClient) {
                if (email.isNotEmpty() && pass.isNotEmpty()) {
                        repo.signin(email, pass,
                            onSuccess = { authResult ->
                                val intent = Intent(requireActivity(), MainActivity::class.java)
                                startActivity(intent)
                            },
                            onFailure = { exception ->
                                Toast.makeText(context,"Empty fields are not allowed !!", Toast.LENGTH_SHORT).show()
                            }
                        )
                } else {
                    Toast.makeText(context, "Empty fields are not allowed !!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Make sure that you have selected user type", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val repo = Repository()
        if(repo.auth.currentUser != null){
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
    }
}