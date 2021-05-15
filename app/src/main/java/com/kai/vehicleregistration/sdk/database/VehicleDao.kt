package com.kai.vehicleregistration.sdk.database

import androidx.room.*
import com.kai.vehicleregistration.model.VehicleEntity

@Dao
interface VehicleDao
{
    @Query("SELECT * FROM vehicle_table" )
    fun getAll(): List<VehicleEntity>

    @Insert
    fun insert( vararg vehicle: VehicleEntity)
}