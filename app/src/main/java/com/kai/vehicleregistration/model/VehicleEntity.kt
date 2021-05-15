package com.kai.vehicleregistration.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle_table")
data class VehicleEntity(
    @PrimaryKey @ColumnInfo(name = "vehicle_number") var mVehicleNumber: String,
    @ColumnInfo(name = "company") var mCompany: String,
    @ColumnInfo(name = "model") var mModel: String,
    @ColumnInfo(name = "fuel_type") var mFuelType: FuelType,
    @ColumnInfo(name = "Transmission") var mTransmission: TransmissionType,
)
