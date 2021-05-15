package com.kai.vehicleregistration.sdk.database

import android.content.Context
import com.kai.vehicleregistration.model.FuelType
import com.kai.vehicleregistration.model.TransmissionType
import com.kai.vehicleregistration.model.VehicleEntity

object VehicleDatabaseSingleton
{
    private lateinit var mDatabase: VehicleDatabase

    fun initDatabaseInstance( context: Context )
    {
        mDatabase = VehicleDatabase( context )
    }

    fun insertVehicle( number: String, company: String, model: String, fuelType: FuelType, transmission: TransmissionType )
    {
        val vehicleEntity = VehicleEntity( number, company, model, fuelType, transmission )
        mDatabase.vehicleDao().insert( vehicleEntity )
    }

    fun getAllVehicles(): MutableList<VehicleEntity>
    {
        val vehicleList = mutableListOf<VehicleEntity>()
        vehicleList.addAll( mDatabase.vehicleDao().getAll() )
        return vehicleList
    }
}