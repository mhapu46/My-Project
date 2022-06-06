package com.example.curencyconverter

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.curencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var from = "USD"


    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding= ActivityMainBinding.inflate(inflater, container, false)
        initSpinner()
        binding.button.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {

    }

    private fun initSpinner() {
        val adapter = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, currencyList)
        binding.from.adapter = adapter
        binding.from.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                from = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }

}