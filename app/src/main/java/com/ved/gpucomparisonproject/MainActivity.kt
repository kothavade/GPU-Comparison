package com.ved.gpucomparisonproject
//https://stackoverflow.com/questions/16770726/google-custom-search-api-for-square-images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ved.gpucomparisonproject.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val n: String = "NVIDIA"
        val a: String = "AMD"
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        val data = ArrayList<Gpu>()
        data.add(Gpu(R.drawable.rtx3070,n,"RTX 3070", 500, 8,"GDDR6","PCIe 4.0 x16", 448, 1.5, 1.73, 650, "Ampere", true,21934, 13701, 153 ))
        data.add(Gpu(R.drawable.rtx3070,n,"RTX 3080", 700, 8,"GDDR6","PCIe 4.0 x16", 448, 1.5, 1.73, 650, "Ampere", true,21934, 13701, 153 ))

        val adapter = CustomAdapter(data)
        binding.recyclerView.adapter=adapter


    }
}