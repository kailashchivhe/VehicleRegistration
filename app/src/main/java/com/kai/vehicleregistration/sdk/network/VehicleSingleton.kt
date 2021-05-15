package com.kai.vehicleregistration.sdk.network;

import com.kai.vehicleregistration.model.Company
import com.kai.vehicleregistration.model.Vehicle
import com.kai.vehicleregistration.model.VehicleType
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VehicleSingleton
{
    private const val mBaseURL = "https://test.turbocare.app/turbo/care/v1/"

    lateinit var mCurrentVehicleEnum: VehicleType

    private val mRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl( mBaseURL )
        .addConverterFactory( GsonConverterFactory.create() )
        .build()

    private val mVehicleServiceInterface = mRetrofit.create( VehicleServiceInterface::class.java )

    fun getCompaniesByType( vehicleType: VehicleType, callback: Callback<Company> )
    {
        mCurrentVehicleEnum = vehicleType
        mVehicleServiceInterface.getCompaniesByType( vehicleType.name )
    }

    fun getVehiclesByCompany( brand: String, callback: Callback<Vehicle> )
    {
        mVehicleServiceInterface.getVehiclesByCompany( mCurrentVehicleEnum.name, brand )
    }
}