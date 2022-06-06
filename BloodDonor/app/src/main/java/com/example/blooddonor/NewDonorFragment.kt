package com.example.blooddonor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.databinding.FragmentNewDonorBinding
import com.example.blooddonor.db.bloodGroupList
import com.example.blooddonor.entities.DonorModel
import com.example.blooddonor.viewmodel.DonorViewModel
import android.widget.ArrayAdapter as ArrayAdapter

class NewDonorFragment : Fragment() {
    private lateinit var binding: FragmentNewDonorBinding
    private val donorViewModel: DonorViewModel by viewModels()
    private var bloodGroup="A+"
    private var gender= ""
    var dateInMillis = System.currentTimeMillis()
    var timeInMillis = System.currentTimeMillis()
    private var donorId = 0L
    private var phone = ""
    private var age= ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNewDonorBinding.inflate(inflater, container, false)
        initSpinner()
        initGenderRadioGroup()
        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {
        val name = binding.inputnameET.text.toString()
        val date = binding.showDateTV.text.toString()
        val donor = DonorModel(
            name = name,
            donorID = donorId,
            date = dateInMillis,
            phoneNumber = phone,
            age = age,
            bloodGroup = bloodGroup,
            gender = gender


        )
        donorViewModel.insertDonor(donor)

        findNavController().popBackStack()
    }

    private fun initGenderRadioGroup() {
        binding.genderRG.setOnCheckedChangeListener { radioGroup, i ->
            val rb: RadioButton = radioGroup.findViewById(i)
            gender = rb.text.toString()
        }

    }

    private fun initSpinner() {
        val adapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            bloodGroupList
        )
        binding.bloodGroup.adapter = adapter

        binding.bloodGroup.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                bloodGroup = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }


}