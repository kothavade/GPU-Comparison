package com.ved.gpucomparisonproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.ved.gpucomparisonproject.R.layout.adapter_custom
import com.ved.gpucomparisonproject.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val list: MutableList<String> = ArrayList()
        list.add("bob")
        list.add("joe")
        list.add("jane")
        list.add("john")
        list.add("john")
        list.add("john")
        list.add("john")
        list.add("john")
        list.add("john")
        list.add("john")

        val customAdapter:CustomAdapter = CustomAdapter(this, adapter_custom,list)
        binding.recyclerView.adapter=customAdapter
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    class CustomAdapter(private val dataset: MutableList<String>)
        val list: MutableList<String> = objects

        public override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(adapter_custom, null)
            val textView: TextView = view.findViewById(R.id.adapterText)
            val button: Button = view.findViewById(R.id.adapterButton)
            textView.text = "Position: $position"
            button.text = list.get(position)
            return view
        }
    }
}