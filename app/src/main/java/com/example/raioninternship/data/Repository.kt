package com.example.raioninternship.data

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

            }
    }

}