package com.example.raioninternship.screen.projectdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raioninternship.R
import com.example.raioninternship.databinding.ScreenProjectDetailBinding

class ProjectDetailScreen : Fragment() {

    private var _binding: ScreenProjectDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ScreenProjectDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        val cardHeader = listOf(
            "Lokasi",
            "Durasi",
            "Crew",
            "Royalty",
            "Deskripsi",
            "Requirement"
        )

        val cardContent = listOf(
            "Malang dan sekitarnya",
            "Waktu pengerjaan 2-3 bulan",
            "Jumlah crew 4 orang",
            "Royalty Rp400,000.00/project",
            "Luxe Project merupakan project yang berfokus pada pengembangan website. Dengan rentang waktu pengerjaan " +
                    "2-3 bulan, kami harap project ini dapat terselesaikan. Kami juga membutuhkan sekitar " +
                    "4 anggota yang membantu dalam pengerjaan project ini. Kami memberi royalty sebesar Rp400,000.00 " +
                    "apabila project ini dapat terselesaikan dengan hasil sesuai yang kami inginkan.",
            "- Mahasiswa aktif Teknik Informatika" +
                    "\n- Menguasai HTML, CSS, JavaScript" +
                    "\n- Menguasai CodeIgniter dan Laravel" +
                    "\n- Menguasai UX Design" +
                    "\n- Menguasai query dan database seperti mySQL"
        )

        val adapter = ProjectDetailAdapter(cardHeader, cardContent)
        binding.rvProjectDetail.adapter = adapter
        binding.rvProjectDetail.layoutManager = LinearLayoutManager(this.context)

        binding.btnTertarik.setOnClickListener(){
            navController.navigate(R.id.projectForm)
        }

        return view
    }

}