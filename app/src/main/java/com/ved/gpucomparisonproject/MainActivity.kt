package com.ved.gpucomparisonproject

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log.d
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputLayout
import com.ved.gpucomparisonproject.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val selectedKey:String = "yo"
        const val savedDataKey:String = "yo1"
        var selected: Int = 0
        var data: ArrayList<GPU> = arrayListOf<GPU>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        var counter: Int = 0
        val n = "NVIDIA"
        val a = "AMD"
        val pH = "PLACEHOLDER"
        val custom: GPU = GPU(R.drawable.custom,pH,pH,pH,pH,pH,pH,pH,pH,pH,pH,pH)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val context = binding.root.context
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        if(savedInstanceState==null) {
            data.add(
                GPU(
                    R.drawable.rtx3060,
                    n,
                    "RTX 3060",
                    "330",
                    "12",
                    "GDDR6",
                    "360",
                    "1.32",
                    "1.77",
                    "170",
                    "Ampere",
                    "Decent value if on a budget."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6600,
                    a,
                    "RX 6600",
                    "330",
                    "8",
                    "GDDR6",
                    "224",
                    "1.63",
                    "2.49",
                    "132",
                    "RDNA2",
                    "Worse alternative to 3060 for the same price."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6600xt,
                    a,
                    "RX 6600 XT",
                    "379",
                    "8",
                    "GDDR6",
                    "256",
                    "1.97",
                    "2.59",
                    "160",
                    "RDNA2",
                    "Mid/Bad alternative to 3060Ti for less money."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3060ti,
                    n,
                    "RTX 3060 Ti",
                    "400",
                    "8",
                    "GDDR6",
                    "448",
                    "1.41",
                    "1.66",
                    "200",
                    "Ampere",
                    "Best value this generation, buy if you can afford."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6700xt,
                    a,
                    "RX 6700 XT",
                    "479",
                    "12",
                    "GDDR6",
                    "384",
                    "2.32",
                    "2.58",
                    "230",
                    "RDNA2",
                    "Marginally better than 3060Ti, not worth."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3070,
                    n,
                    "RTX 3070",
                    "500",
                    "8",
                    "GDDR6",
                    "448",
                    "1.5",
                    "1.73",
                    "220",
                    "Ampere",
                    "Marginally better than 3060Ti, not worth."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6800,
                    a,
                    "RX 6800",
                    "579",
                    "16",
                    "GDDR6",
                    "512",
                    "1.70",
                    "2.10",
                    "250",
                    "RDNA2",
                    "Decent choice in-between 3070 and 3080, worth the price."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3070ti,
                    n,
                    "RTX 3070 Ti",
                    "600",
                    "8",
                    "GDDR6X",
                    "608",
                    "1.57",
                    "1.77",
                    "290",
                    "Ampere",
                    "Bad value, buy 3060Ti or 3080."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6800xt,
                    a,
                    "RX 6800 XT",
                    "679",
                    "16",
                    "GDDR6",
                    "512",
                    "2.01",
                    "2.25",
                    "300",
                    "RDNA2",
                    "Great alternative to 3080, great deal. "
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3080,
                    n,
                    "RTX 3080",
                    "700",
                    "10",
                    "GDDR6X",
                    "760",
                    "1.44",
                    "1.71",
                    "320",
                    "Ampere",
                    "Great value for high performance. Second best value this generation."
                )
            )
            data.add(
                GPU(
                    R.drawable.rx6900xt,
                    a,
                    "RX 6900 XT",
                    "1000",
                    "16",
                    "GDDR6",
                    "512",
                    "1.82",
                    "2.25",
                    "300",
                    "RDNA2",
                    "Performs well if you have money to burn, generally not worth it."
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3080ti,
                    n,
                    "RTX 3080 Ti",
                    "1200",
                    "12",
                    "GDDR6X",
                    "912",
                    "1.36",
                    "1.66",
                    "350",
                    "Ampere",
                    "Horrible deal, buy 3080"
                )
            )
            data.add(
                GPU(
                    R.drawable.rtx3090,
                    n,
                    "RTX 3090",
                    "1500",
                    "24",
                    "GDDR6X",
                    "760",
                    "1.39",
                    "1.69",
                    "350",
                    "Ampere",
                    "Only buy if you need VRAM for GFX"
                )
            )
            fill()
        }
        val adapter = CustomAdapter(data){ GPU ->

            binding.memory.text="VRAM: ${GPU.memory}GB ${GPU.vram}"
            binding.bandwidth.text="Bandwidth: ${GPU.bandwidth} GB/s"
            binding.baseClock.text="Base Clock: ${GPU.baseClock} GHz"
            binding.boostClock.text="Base Clock: ${GPU.boostClock} GHz"
            binding.tdp.text="TDP: ${GPU.tdp}W"
            binding.architecture.text="Architecture: ${GPU.architecture}"
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                binding.review!!.text ="Review: ${GPU.review}"
            }
            binding.imageView.setImageResource(GPU.image)
        }
        fun alertDialog(component: String) {
            val textInputLayout = TextInputLayout(context)
            textInputLayout.setPadding(
                19.dpToPixels().toInt(),
                0,
                19.dpToPixels().toInt(),
                0
            )
            val input = EditText(context)
            input.setPadding(0,55,0,30)
            textInputLayout.hint = component
            textInputLayout.addView(input)
            val alert = AlertDialog.Builder(context)
                .setTitle("Input $component")
                .setView(textInputLayout)
                .setMessage("Please enter the value of ${component.lowercase()} for your custom GPU")
                .setPositiveButton("Submit") { dialog, _ ->
                    d("test", counter.toString())
                    when(counter){
                        0-> {
                            if (input.text.toString().isNotEmpty()) {
                                custom.manufacturer = input.text.toString()
                                alertDialog("Name")
                                counter=1
                            }
                            else{
                                alertDialog("Manufacturer")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=0
                            }
                        }
                        1-> {
                            if (input.text.toString().isNotEmpty()) {
                                custom.name = input.text.toString()
                                alertDialog("Price")
                                counter=2
                            }
                            else{
                                alertDialog("Name")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=1
                            }
                        }
                        2->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.price = input.text.toString()
                                alertDialog("Memory")
                                counter=3
                            }
                            else{
                                alertDialog("Price")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=2
                            }
                        }
                        3->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.memory = input.text.toString()
                                alertDialog("VRAM")
                                counter=4
                            }
                            else{
                                alertDialog("Memory")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=3
                            }
                        }
                        4->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.vram = input.text.toString()
                                alertDialog("Bandwidth")
                                counter=5
                            }
                            else{
                                alertDialog("VRAM")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=4
                            }
                        }
                        5->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.bandwidth = input.text.toString()
                                alertDialog("Base Clock")
                                counter=6
                            }
                            else{
                                alertDialog("Bandwidth")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=5
                            }
                        }
                        6->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.baseClock = input.text.toString()
                                alertDialog("Boost Clock")
                                counter=7
                            }
                            else{
                                alertDialog("Base Clock")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=6
                            }
                        }
                        7->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.boostClock = input.text.toString()
                                alertDialog("TDP")
                                counter=8
                            }
                            else{
                                alertDialog("Boost Clock")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=7
                            }
                        }
                        8->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.tdp = input.text.toString()
                                alertDialog("Architecture")
                                counter=9
                            }
                            else{
                                alertDialog("TDP")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=8
                            }
                        }
                        9->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.architecture = input.text.toString()
                                alertDialog("Review")
                                counter=10
                            }
                            else{
                                alertDialog("Architecture")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=9
                            }
                        }
                        10->{
                            if (input.text.toString().isNotEmpty()) {
                                custom.review = input.text.toString()
                                counter=-1
                            }
                            else{
                                alertDialog("Review")
                                Toast.makeText(context,"Please enter a value for $component",Toast.LENGTH_LONG).show()
                                counter=10
                            }

                        }
                        else->{
                            val customCopy = custom.copy()
                            data.add(customCopy)
                            data.sortWith(compareBy { it.price.toDouble() })
                            selected=data.indexOf(customCopy)
                            adapter.notifyDataSetChanged()
                            fill()
                            counter=0
                        }
                    }
                    dialog.cancel()
                }.create()
            input.requestFocus()
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT)
            alert.setCanceledOnTouchOutside(false);
            alert.show()
        }
        binding.addGPU.setOnClickListener {
            alertDialog("Manufacturer")
        }
        binding.recyclerView.adapter=adapter

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(selectedKey,selected)
        outState.putSerializable(savedDataKey, data)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        selected=savedInstanceState.getInt(selectedKey)
        data=savedInstanceState.getSerializable(savedDataKey) as ArrayList<GPU>
        fill()
    }
    fun fill(){
        binding.memory.text="VRAM: ${data[selected].memory}GB ${data[selected].vram}"
        binding.bandwidth.text="Bandwidth: ${data[selected].bandwidth} GB/s"
        binding.baseClock.text="Base Clock: ${data[selected].baseClock} GHz"
        binding.boostClock.text="Base Clock: ${data[selected].boostClock} GHz"
        binding.tdp.text="TDP: ${data[selected].tdp}W"
        binding.architecture.text="Architecture: ${data[selected].architecture}"
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.review!!.text ="Review: ${data[selected].review}"
        }
        binding.imageView.setImageResource(data[selected].image)
    }

    private fun Int.dpToPixels():Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,this.toFloat(),binding.root.context.resources.displayMetrics
    )

}