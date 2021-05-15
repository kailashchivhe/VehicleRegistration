package com.kai.vehicleregistration.sdk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kai.vehicleregistration.model.VehicleEntity

@Database( entities = [VehicleEntity::class], version = 1 )
abstract class VehicleDatabase : RoomDatabase()
{
    abstract fun vehicleDao(): VehicleDao

    companion object
    {
        @Volatile private var instance: VehicleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK)
        {
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase( context: Context ) = Room.databaseBuilder(context,
            VehicleDatabase::class.java, "vehicle-list.db")
            .build()
    }
}