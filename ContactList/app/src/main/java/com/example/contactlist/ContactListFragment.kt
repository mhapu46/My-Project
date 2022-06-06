package com.example.contactlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlist.databinding.FragmentContactListBinding


class ContactListFragment : Fragment() {
    private lateinit var binding: FragmentContactListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(inflater, container, false)
        val adapter= ContactAdapter{
            findNavController().navigate(R.id.action_contactListFragment_to_contactDetailsFragment)
        }
        binding.contactListRV.layoutManager = LinearLayoutManager(activity)
        binding.contactListRV.adapter = adapter
        adapter.submitList(contactList)
        binding.floatingActionButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_contactListFragment_to_newContactFragment)
        }

        return binding.root
    }

}