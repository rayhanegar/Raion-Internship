package com.example.raioninternship.screen.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.R
import com.example.raioninternship.data.Repository
import com.example.raioninternship.databinding.ScreenSignupBinding

class SignUpScreen : Fragment() {

    private lateinit var binding: ScreenSignupBinding
    private val repo = Repository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenSignupBinding.inflate(layoutInflater)
        val view = binding.root
        val navController = findNavController()

        binding.signin.setOnClickListener {
            navController.navigate(R.id.signInScreen)
        }

        binding.btnSeeker.setOnClickListener {
            binding.btnSeeker.isSelected = true
            binding.btnClient.isSelected = false
        }

        binding.btnClient.setOnClickListener {
            binding.btnClient.isSelected = true
            binding.btnSeeker.isSelected = false
        }

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.checkBox.isChecked = isChecked
        }

        binding.btnSignup.setOnClickListener {
            val fullname = binding.fullnameEditText.text.toString()
            val phonenum = binding.phonenumberEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val pass = binding.passEditText.text.toString()
            val confirmPass = binding.confirmpassEditText.text.toString()
            val isSeeker = binding.btnSeeker.isSelected
            val isClient = binding.btnClient.isSelected
            val agree = binding.checkBox.isChecked


            if (agree && (isSeeker || isClient)) {
                if (fullname.isNotEmpty() && phonenum.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                    if (pass == confirmPass) {
                        repo.signup(fullname, phonenum, email, pass, confirmPass,
                            onSuccess = { _ ->
                                navController.navigate(R.id.homepageScreen)
                            },
                            onFailure = { _ ->
                                Toast.makeText(requireContext(), "Signup failed.", Toast.LENGTH_SHORT).show()
                                Toast.makeText(requireContext(), "Logged-in in preview mode.", Toast.LENGTH_LONG).show()
                                navController.navigate(R.id.homepageScreen)
                            }
                        )
                    } else {
                        Toast.makeText(requireContext(), "Password is not matching", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Empty fields are not allowed!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Make sure that you agree to terms and select user type", Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }

}
