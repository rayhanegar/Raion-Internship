package com.example.raioninternship.screen.homepage.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raioninternship.R
import com.example.raioninternship.adapter.ViewPagerAdapter
import com.example.raioninternship.databinding.FragmentHomepageBannerBinding

class HomepageBanner : Fragment() {

    private var _binding : FragmentHomepageBannerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentHomepageBannerBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            HomepageBanner1(),
            HomepageBanner2(),
            HomepageBanner3(),
            HomepageBanner4()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.vpBanner.adapter = adapter

        return view
    }
}