package com.example.contactlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.contactlist.databinding.FragmentContactDetailsBinding


class ContactDetailsFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        binding.callBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel: 01937759779")
                }
                startActivity(intent)
            }
            catch (e: ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not launch any app", Toast.LENGTH_SHORT).show()
            }
        }
        binding.mailBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    type = "*/*"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("tanvir@pencilbox.edu.bd"))
                    putExtra(Intent.EXTRA_SUBJECT, "email test")
                    //putExtra(Intent.EXTRA_STREAM, attachment)
                }
                startActivity(intent)
            }catch (e: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), "could not launch any app", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.mapBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("geo:0,0?q=EDB Trade center, kawranbazar, dhaka")
                }
                startActivity(intent)
            }catch (e: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), "could not launch any app", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return binding.root
    }


}