package com.example.raioninternship.data

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.raioninternship.screen.sign.SignInScreen
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

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





}