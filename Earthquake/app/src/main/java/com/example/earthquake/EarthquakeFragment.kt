package com.example.earthquake

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquake.Custom.DatePickerFragment
import com.example.earthquake.adapter.EarthquakeAdapter
import com.example.earthquake.databinding.FragmentEarthquakeBinding
import com.example.earthquake.viewmodels.EarthquakeViewModel
import kotlin.math.log

class EarthquakeFragment : Fragment() {
    private lateinit var binding: FragmentEarthquakeBinding
    private var from = "1"
    private val earthquakeViewModel: EarthquakeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEarthquakeBinding.inflate(inflater, container, false)
        initSpinner()
        binding.fromBtn.setOnClickListener {
            DatePickerFragment{
            }.show(childFragmentManager, null)
        }
        binding.toBtn.setOnClickListener {
            DatePickerFragment{
            }.show(childFragmentManager, null)
        }
        val adapter= EarthquakeAdapter()
        binding.eqlistRV.layoutManager= LinearLayoutManager(requireActivity()).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.eqlistRV.adapter = adapter
        earthquakeViewModel.fetchData()
        Log.d("ViewModel", "${earthquakeViewModel}")


        return binding.root
    }

    private fun initSpinner() {
        val adapter = ArrayAdapter<String>(
            requireActivity(),
            R.layout.simple_spinner_dropdown_item,
            recterList
        )
        binding.recterSp.adapter = adapter

        binding.recterSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                from = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }


}
val recterList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")