package com.example.blooddonor.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.blooddonor.db.DonorDatabase
import com.example.blooddonor.entities.DonorModel
import com.example.blooddonor.repos.DonorRepository
import kotlinx.coroutines.launch

class DonorViewModel (application: Application) : AndroidViewModel(application) {
    private val donorDao = DonorDatabase.getDB(application).donorDao()
    private val repository = DonorRepository(donorDao)
    var donorList = listOf<DonorModel>()
    val idLD: MutableLiveData<Long> = MutableLiveData()
    fun insertDonor(todoModel: DonorModel){
        viewModelScope.launch {
            idLD.value = repository.insertDonor(todoModel)
        }
    }

    fun updateDonor(donorModel: DonorModel) {
        viewModelScope.launch {
            repository.updateDonor(donorModel)
        }
    }

    fun deleteDonor(donorModel: DonorModel) {
        viewModelScope.launch {
            repository.deleteDonor(donorModel)
        }
    }
}