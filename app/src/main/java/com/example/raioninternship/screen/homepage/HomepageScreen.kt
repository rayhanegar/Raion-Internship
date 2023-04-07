package com.example.raioninternship.screen.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raioninternship.R
import com.example.raioninternship.adapter.ViewPagerAdapter
import com.example.raioninternship.databinding.ScreenHomepageBinding
import com.example.raioninternship.screen.homepage.banner.*
import com.example.raioninternship.screen.homepage.contract.HomepageContract

class HomepageScreen : Fragment() {

    private var _binding : ScreenHomepageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = ScreenHomepageBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        val bannerList = arrayListOf<Fragment>(
            HomepageBanner1(),
            HomepageBanner2(),
            HomepageBanner3(),
            HomepageBanner4()
        )

        val contractList = listOf(
            "Luxe Web Development",
            "Maju Group Front-end",
            "Lexus Virtual Showroom",
            "NASA Artemis Hackjam"
        )

        val bannerAdapter = ViewPagerAdapter(bannerList, requireActivity().supportFragmentManager, lifecycle)
        binding.vpBanner.adapter = bannerAdapter

        val contractAdapter = HomepageContractAdapter(contractList)
        binding.rvContract.adapter = contractAdapter
        binding.rvContract.layoutManager = LinearLayoutManager(this.context)

        return view
    }


}