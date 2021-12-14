package com.ved.gpucomparisonproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ved.gpucomparisonproject.databinding.ActivityMainBinding
import java.lang.Exception
import java.lang.Integer.min

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val selectedKey:String = "yo"
        const val savedDataKey:String = "yo1"
        var selected: Int = 0
        var data: ArrayList<GPU> = arrayListOf<GPU>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val n = "NVIDIA"
        val a = "AMD"
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        if(savedInstanceState==null) {
            data.add(
                GPU(
                    R.drawable.rtx3060,
                    n,
                    "RTX 3060",
                    330,
                    12,
                    "GDDR6",
                    360,
                    1.32,
                    1.77,
                    170,
                    "Ampere",
                    "Decent value if on a budget."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6600,
                    a,
                    "RX 6600",
                    330,
                    8,
                    "GDDR6",
                    224,
                    1.63,
                    2.49,
                    132,
                    "RDNA2",
                    "Worse alternative to 3060 for the same price."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6600xt,
                    a,
                    "RX 6600 XT",
                    379,
                    8,
                    "GDDR6",
                    256,
                    1.97,
                    2.59,
                    160,
                    "RDNA2",
                    "Mid/Bad alternative to 3060Ti for less money."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3060ti,
                    n,
                    "RTX 3060 Ti",
                    400,
                    8,
                    "GDDR6",
                    448,
                    1.41,
                    1.66,
                    200,
                    "Ampere",
                    "Best value this generation, buy if you can afford."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6700xt,
                    a,
                    "RX 6700 XT",
                    479,
                    12,
                    "GDDR6",
                    384,
                    2.32,
                    2.58,
                    230,
                    "RDNA2",
                    "Marginally better than 3060Ti, not worth."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3070,
                    n,
                    "RTX 3070",
                    500,
                    8,
                    "GDDR6",
                    448,
                    1.5,
                    1.73,
                    220,
                    "Ampere",
                    "Marginally better than 3060Ti, not worth."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6800,
                    a,
                    "RX 6800",
                    579,
                    16,
                    "GDDR6",
                    512,
                    1.70,
                    2.10,
                    250,
                    "RDNA2",
                    "Decent choice in-between 3070 and 3080, worth the price."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3070ti,
                    n,
                    "RTX 3070 Ti",
                    600,
                    8,
                    "GDDR6X",
                    608,
                    1.57,
                    1.77,
                    290,
                    "Ampere",
                    "Bad value, buy 3060Ti or 3080."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6800xt,
                    a,
                    "RX 6800 XT",
                    679,
                    16,
                    "GDDR6",
                    512,
                    2.01,
                    2.25,
                    300,
                    "RDNA2",
                    "Great alternative to 3080, great deal. "
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3080,
                    n,
                    "RTX 3080",
                    700,
                    10,
                    "GDDR6X",
                    760,
                    1.44,
                    1.71,
                    320,
                    "Ampere",
                    "Great value for high performance. Second best value this generation."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6900xt,
                    a,
                    "RX 6900 XT",
                    1000,
                    16,
                    "GDDR6",
                    512,
                    1.82,
                    2.25,
                    300,
                    "RDNA2",
                    "Performs well if you have money to burn, generally not worth it."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3080ti,
                    n,
                    "RTX 3080 Ti",
                    1200,
                    12,
                    "GDDR6X",
                    912,
                    1.36,
                    1.66,
                    350,
                    "Ampere",
                    "Horrible deal, buy 3080"
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3090,
                    n,
                    "RTX 3090",
                    1500,
                    24,
                    "GDDR6X",
                    760,
                    1.39,
                    1.69,
                    350,
                    "Ampere",
                    "Only buy if you need VRAM for GFX"
                )
            )
            fill()
        }
        val adapter = CustomAdapter(data){ GPU ->
            binding.memory.text="VRAM: " + GPU.memory.toString() + " " +  GPU.vram
            binding.imageView.setImageResource(GPU.image)
        }
        binding.removeSelected.setOnClickListener {
            try {
                if(data.size>1) {
                    data.removeAt(selected)
                    adapter.notifyDataSetChanged()
                    selected = min(selected,data.size-1)
                    fill()
                }
                else {
                    binding.removeSelected.isEnabled = false
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Uh oh.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.recyclerView.adapter=adapter
    }
    override fun onSaveInstanceState(outState: Bundle) {
        d("yo", "save")
        super.onSaveInstanceState(outState)
        outState.putInt(selectedKey,selected)
        outState.putSerializable(savedDataKey, data)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        d("yo", "Restore")
        super.onRestoreInstanceState(savedInstanceState)
        selected=savedInstanceState.getInt(selectedKey)
        data=savedInstanceState.getSerializable(savedDataKey) as ArrayList<GPU>
        fill()
    }
    fun fill(){
        binding.memory.text="VRAM: " + data.get(selected).memory.toString() + " " + data.get(selected).vram
        binding.imageView.setImageResource(data[selected].image)
    }
}