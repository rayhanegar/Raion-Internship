package com.example.raioninternship.screen.sign

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.raioninternship.MainActivity
import com.example.raioninternship.data.Repository
import com.example.raioninternship.databinding.ScreenSignupBinding

class SignUpScreen : Fragment() {

    //Var binding dideklarasikan untuk bisa mengakses UI pada screen_signup.xml
    private lateinit var binding: ScreenSignupBinding
    val repo = Repository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //digunakan untuk membuat sebuah objek binding yang menghubungkan layout XML ScreenSignup dengan kode Kotlin.
        //digunakan untuk menampilkan layout yang telah dihubungkan dengan kode Kotlin menggunakan binding
        binding = ScreenSignupBinding.inflate(layoutInflater)
        val view = binding.root

        //sebuah listener yang menghub button signup dengan binding
        //listener bertugas untuk melakukan aksi yang diinginkan ketika tombol tersebut ditekan
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
                if (fullname.isNotEmpty() && phonenum.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()
                    && confirmPass.isNotEmpty()) {
                    if (pass == confirmPass) {
                        repo.signup(fullname, phonenum, email, pass, confirmPass,
                            onSuccess = { authResult ->
                                val intent = Intent(requireActivity(), SignInScreen::class.java)
                                startActivity(intent)
                            },
                            onFailure = { exception ->
                                Toast.makeText(context,"Empty fields are not allowed !!", Toast.LENGTH_SHORT).show()
                            }
                        )
                    } else {
                        Toast.makeText(context, "Password is not matching", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Empty fields are not allowed !!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Make sure that you agree to terms and select user type", Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }

}