package com.example.raioninternship.data

import android.content.Intent
import android.widget.Toast
import com.example.raioninternship.databinding.ScreenChangePasswordBinding
import com.example.raioninternship.screen.sign.SignInScreen
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.firestore.FirebaseFirestore

class Repository {
    val auth = FirebaseAuth.getInstance()
    val database = FirebaseFirestore.getInstance()

    fun signin(email: String, password: String, onSuccess:(AuthResult) -> Unit, onFailure: (Exception) -> Unit){
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess(it)
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }

    fun signup(fullname: String, phonenum: String, email: String, password: String, confirmpass: String,
        onSuccess: (AuthResult) -> Unit, onFailure: (Exception) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess(it)
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }

    fun changePass(binding: ScreenChangePasswordBinding) {
        val user = auth.currentUser

        binding.btnConfirm.setOnClickListener newChangePassword@{

            val email = binding.emailEditText.text.toString()
            val lastpass = binding.lastpassEditText.text.toString()
            val newPass = binding.newpassEditText.text.toString()
            val passConfirm = binding.confirmpassEditText.text.toString()

            if (email.isEmpty()) {
                binding.emailEditText.error = "Email Tidak Boleh Kosong"
                binding.emailEditText.requestFocus()
                return@newChangePassword
            }

            if (newPass.isEmpty()) {
                binding.newpassEditText.error = "Password Tidak Boleh Kosong"
                binding.newpassEditText.requestFocus()
                return@newChangePassword
            }

            if(passConfirm.isEmpty()){
                binding.confirmpassEditText.error = "Ulangi Password Baru"
                binding.confirmpassEditText.requestFocus()
                return@newChangePassword
            }

            if (newPass != passConfirm) {
                binding.newpassEditText.error = "Password Tidak Sama"
                binding.confirmpassLayout.error = "Password Tidak Sama"
                binding.newpassEditText.requestFocus()
                return@newChangePassword
            }

            user?.let {
                val userCredential = EmailAuthProvider.getCredential(it.email!!, lastpass)
                it.reauthenticate(userCredential).addOnCompleteListener { task ->
                    when {
                        task.isSuccessful -> {
                            user.updatePassword(newPass).addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Toast.makeText(binding.root.context, "Password Berhasil diUpdate", Toast.LENGTH_SHORT).show()
                                    auth.signOut()
                                    val intent = Intent(binding.root.context, SignInScreen::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    binding.root.context.startActivity(intent)
                                    Toast.makeText(binding.root.context, "Silahkan Sign in Kembali", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(binding.root.context, "${updateTask.exception?.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                        task.exception is FirebaseAuthInvalidCredentialsException -> {
                            binding.lastpassEditText.error = "Password Salah"
                            binding.lastpassEditText.requestFocus()
                        }
                        else -> {
                            Toast.makeText(binding.root.context, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }


        }
    }
}

