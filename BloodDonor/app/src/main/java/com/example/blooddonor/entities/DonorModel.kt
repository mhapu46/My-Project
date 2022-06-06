package com.example.blooddonor.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_todo")
data class DonorModel(
    @PrimaryKey
    @ColumnInfo(name = "donor_id")
    var donorID: Long= 0,
    val name: String,
    @ColumnInfo(name= "phone_number")
    val phoneNumber: String,
    val gender: String,
    val age: String,
    @ColumnInfo(name= "blood_group")
    val bloodGroup: String,
    var date: Long = System.currentTimeMillis(),
)
