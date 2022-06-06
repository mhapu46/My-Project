package com.example.blooddonor.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.blooddonor.entities.DonorModel
@Dao
interface DonorDao {
    @Insert
    suspend fun insertDonor(donorModel: DonorModel) : Long

    @Update
    suspend fun updateDonor(donorModel: DonorModel)

    @Delete
    suspend fun deleteDonor(donorModel: DonorModel)
}