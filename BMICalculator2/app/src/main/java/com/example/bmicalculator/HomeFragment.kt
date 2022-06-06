package com.example.bmicalculator

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private lateinit var weightET : EditText
    private lateinit var heightET : EditText
    private lateinit var calculateBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weightET = view.findViewById(R.id.weightET)
        heightET = view.findViewById(R.id.heightET)
        calculateBtn = view.findViewById(R.id.calculateBtn)
        calculateBtn.setOnClickListener{
            val weight = weightET.text.toString()
            val height = heightET.text.toString()
            if (weight.isEmpty()){
                weightET.error = "This filed must not be empty"
                return@setOnClickListener
            }
            if (height.isEmpty()){
                heightET.error = "This filed must not be empty"
                return@setOnClickListener
            }
            val W = weight.toDouble()
            val H = height.toDouble()
            val BMI = W/(H*H)
            val bundle = Bundle().apply {
                putDouble("BMI_score", BMI)
            }
            findNavController().navigate(R.id.home_to_result, bundle)
        }
    }

}