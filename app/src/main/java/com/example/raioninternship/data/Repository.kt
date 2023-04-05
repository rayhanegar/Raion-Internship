package com.example.raioninternship.data

import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Repository {
    val auth = FirebaseAuth.getInstance()
    val database = FirebaseFirestore.getInstance()

    fun login(email: String, password: String, onSuccess:(AuthResult) -> Unit){
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess(it)
            }
            .addOnFailureListener {
                //Toast.makeText(context, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
    }

    fun signup(fullname: String, phonenum: String, email: String, password: String, confirmpass: String,
        onSuccess: (AuthResult) -> Unit) {

    }

}