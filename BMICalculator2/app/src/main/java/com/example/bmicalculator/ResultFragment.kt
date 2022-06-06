package com.example.bmicalculator

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultFragment : Fragment() {
    private lateinit var score : TextView
    private lateinit var stage : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        score = view.findViewById(R.id.bmiTV1)
        stage = view.findViewById(R.id.bmiTV2)

        val BMI = arguments?.getDouble("BMI_score")
        score.text = String.format("%.2f",BMI)
        if (BMI!! < 18.5) {
            stage.text = "Your Are Under Weight"
            stage.setTextColor(Color.parseColor("#0277BD"))
        } else if (BMI >= 18.5 && BMI < 24.9) {
            stage.text = "Your Are Healthy"
            stage.setTextColor(Color.parseColor("#64DD17"))
        } else if (BMI >= 24.9 && BMI < 30) {
            stage.text = "Your Are Overweight"
            stage.setTextColor(Color.parseColor("#FFAB00"))
        } else if (BMI >= 30) {
           stage.text = "Your Are Suffering from Obesity"
            stage.setTextColor(Color.parseColor("#DD2C00"))
        }




    }


    }

