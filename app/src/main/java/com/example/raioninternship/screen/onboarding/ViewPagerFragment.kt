package com.example.raioninternship.screen.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.raioninternship.databinding.FragmentViewPagerBinding
import com.example.raioninternship.screen.onboarding.onboardingScreen.Onboarding1
import com.example.raioninternship.screen.onboarding.onboardingScreen.Onboarding2
import com.example.raioninternship.screen.onboarding.onboardingScreen.Onboarding3
import com.example.raioninternship.screen.onboarding.onboardingScreen.Onboarding4

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            Onboarding1(),
            Onboarding2(),
            Onboarding3(),
            Onboarding4()
        )

        val adapter = ViewPagerAdapter (fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        val dotsIndicator = binding.dotsIndicator
        dotsIndicator.attachTo(binding.viewPager)

        return view

    }
}