package com.example.blooddonor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.blooddonor.R
import com.example.blooddonor.databinding.DonorRowBinding
import com.example.blooddonor.entities.DonorModel

class DonorAdapter(val actionCallback: (DonorModel, String) -> Unit) : ListAdapter<DonorModel, DonorAdapter.DonorViewHolder>(TodoDiffCallback()) {
    class DonorViewHolder(
        private val binding: DonorRowBinding,
        val actionCallback: (DonorModel, String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(donorModel: DonorModel) {
            binding.donor = donorModel

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonorViewHolder {
        val binding = DonorRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DonorViewHolder(binding, actionCallback)
    }

    override fun onBindViewHolder(holder: DonorViewHolder, position: Int) {
        val donorModel = getItem(position)
        holder.bind(donorModel)
    }
}

class TodoDiffCallback : DiffUtil.ItemCallback<DonorModel>() {
    override fun areItemsTheSame(oldItem: DonorModel, newItem: DonorModel): Boolean {
        return oldItem.donorID == newItem.donorID
    }

    override fun areContentsTheSame(oldItem: DonorModel, newItem: DonorModel): Boolean {
        return oldItem == newItem
    }
}