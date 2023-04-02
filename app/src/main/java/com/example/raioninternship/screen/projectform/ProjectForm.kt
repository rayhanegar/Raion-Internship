package com.example.raioninternship.screen.projectform

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.raioninternship.R
import com.example.raioninternship.databinding.ScreenProjectFormBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProjectForm : Fragment() {

    private var _binding: ScreenProjectFormBinding? = null
    private val binding get() = _binding!!

    private val applicantsCollectionRef = Firebase.firestore
        .collection("projects")
        .document("IfLY6JTP6qaf5fnduOzl")
        .collection("applicants")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ScreenProjectFormBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        binding.etNama.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.cbNama.isChecked = !p0.isNullOrEmpty()
            }

        })

        binding.etCV.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.cbCV.isChecked = !p0.isNullOrEmpty()
            }

        })

        binding.etGitHub.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.cbGitHub.isChecked = !p0.isNullOrEmpty()
            }

        })

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.cbEmail.isChecked = !p0.isNullOrEmpty()
            }

        })

        binding.btnApply.setOnClickListener(){
            if(isFormComplete()){
                saveToFirestore()
                navController.navigate(R.id.projectApplyScreen)
            } else {
                Toast.makeText(this@ProjectForm.context, "Please fill all the form!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivBack.setOnClickListener(){
            navController.navigate(R.id.projectDetail)
        }

        return view
    }

    private fun isFormComplete(): Boolean {
        return !binding.etNama.text.isNullOrEmpty() &&
                !binding.etCV.text.isNullOrEmpty() &&
                !binding.etGitHub.text.isNullOrEmpty() &&
                !binding.etEmail.text.isNullOrEmpty() &&
                !binding.etDescription.text.isNullOrEmpty()
    }

    private fun saveToFirestore() = CoroutineScope(Dispatchers.IO).launch{

        try {
            val nama = binding.etNama.text.toString()
            val cvLink = binding.etCV.text.toString()
            val gitHub = binding.etGitHub.text.toString()
            val email = binding.etEmail.text.toString()

            val newApplicant = hashMapOf(
                "nama" to nama,
                "cvLink" to cvLink,
                "gitHub" to gitHub,
                "email" to email
            )

            applicantsCollectionRef.add(newApplicant).await()
            withContext(Dispatchers.Main){
                Toast.makeText(this@ProjectForm.context, "Successfully saved your application", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            withContext(Dispatchers.Main){
                Toast.makeText(this@ProjectForm.context, e.message, Toast.LENGTH_SHORT).show()
            }
        }

    }

}