package com.example.contactlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.contactlist.databinding.FragmentNewContactAddBinding

class NewContactFragmentAdd : Fragment() {
    private lateinit var binding: FragmentNewContactAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewContactAddBinding.inflate(inflater, container, false)
/*        binding.saveBtn.setOnClickListener {
            saveInfo()
        }*/
        return binding.root
    }

    private fun saveInfo() {
        val contactName = binding.inputContactNameET.text.toString()
        val phone = binding.inputPhoneET.text.toString()
        val email = binding.inputEmailET.text.toString()
        val address = binding.inputAddressET.text.toString()
        val contact = Contact(
            id = System.currentTimeMillis(),
            contactName= contactName,
            phone = phone,
            email = email,
            address = address,
        )
        contactList.add(contact)
        findNavController().navigate(R.id.action_newContactFragment_to_contactListFragment)
    }



}