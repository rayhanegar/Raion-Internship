package com.example.raioninternship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raioninternship.R
import com.example.raioninternship.databinding.ActivityProjectDetailBinding
import com.example.raioninternship.projectdetails.ProjectDetailAdapter

class ProjectDetail : AppCompatActivity() {

    private lateinit var binding: ActivityProjectDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.rvProjectDetail.layoutManager = LinearLayoutManager(this)

        binding.btnTertarik.setOnClickListener(){

        }
    }
}