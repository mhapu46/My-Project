package com.example.blooddonor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.databinding.FragmentDonorListBinding


class DonorListFragment : Fragment() {
    private lateinit var binding: FragmentDonorListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDonorListBinding.inflate(inflater, container, false)
        binding.add.setOnClickListener {
            findNavController().navigate(R.id.action_donorListFragment_to_newDonorFragment)
        }
        return binding.root
    }


}