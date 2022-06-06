package com.example.blooddonor.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blooddonor.daos.DonorDao
import com.example.blooddonor.entities.DonorModel

@Database(entities = [DonorModel::class], version = 1)
abstract class DonorDatabase: RoomDatabase() {
    abstract fun donorDao() : DonorDao

    companion object {
        private var db: DonorDatabase? = null
        fun getDB(context: Context) : DonorDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    DonorDatabase::class.java,
                    "todo_db"
                ).build()
                return db!!
            }
            return db!!
        }
    }
}