package com.example.raioninternship.screen.homepage.contract

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raioninternship.R
import com.example.raioninternship.databinding.FragmentHomepageContractBinding

class HomepageContract : Fragment() {

    private var _binding: FragmentHomepageContractBinding? = null;
    private val binding get()  = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomepageContractBinding.inflate(inflater, container,false)
        val view = binding.root

        val fragmentActive  = HomepageContractActive()
        val fragmentPending = HomepageContractPending()

        childFragmentManager.beginTransaction()
            .replace(R.id.flContractContainer, fragmentActive)
            .commit()

        binding.btnActive.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.flContractContainer, fragmentActive)
                .commit()
        }

        binding.btnPending.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.flContractContainer, fragmentPending)
                .commit()
        }

        return view
    }

}