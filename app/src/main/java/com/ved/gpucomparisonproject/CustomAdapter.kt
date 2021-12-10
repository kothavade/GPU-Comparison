package com.ved.gpucomparisonproject

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ved.gpucomparisonproject.databinding.AdapterCustomBinding

class CustomAdapter(
    private val gpuList: List<Gpu>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = AdapterCustomBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_custom, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Gpu = gpuList[position]
        with(holder){
            binding.adapterManufacturer.text=Gpu.manufacturer
            if (binding.adapterManufacturer.equals("NVIDIA"))
                binding.adapterManufacturer.setTextColor(Color.GREEN)
            else
                binding.adapterManufacturer.setTextColor(Color.RED)
            binding.adapterName.text=Gpu.name
            binding.adapterPrice.text="$" + Gpu.price
        }
    }

    override fun getItemCount(): Int {
        return gpuList.size
    }

}