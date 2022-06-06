package com.example.blooddonor.repos

import com.example.blooddonor.daos.DonorDao
import com.example.blooddonor.entities.DonorModel

class DonorRepository (val donorDao: DonorDao){
    suspend fun insertDonor(donorModel: DonorModel) : Long{
        return donorDao.insertDonor(donorModel)
    }

    suspend fun updateDonor(donorModel: DonorModel) = donorDao.updateDonor(donorModel)

    suspend fun deleteDonor(donorModel: DonorModel) = donorDao.deleteDonor(donorModel)
}