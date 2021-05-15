package com.kai.vehicleregistration.sdk.network;

import com.kai.vehicleregistration.model.VehicleType
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VehicleSingleton
{
    private const val mBaseURL = "https://test.turbocare.app/"

    lateinit var mCurrentVehicleEnum: VehicleType

    private val mRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl( mBaseURL )
        .addConverterFactory( GsonConverterFactory.create() )
        .build()

    private val mVehicleServiceInterface = mRetrofit.create( VehicleServiceInterface::class.java )

    fun getCompaniesByType( vehicleType: VehicleType, callback: Callback< MutableList<String> > )
    {
        mCurrentVehicleEnum = vehicleType
        mVehicleServiceInterface.getCompaniesByType( vehicleType.description ).enqueue( callback )
    }

    fun getVehiclesByCompany( brand: String, callback: Callback< MutableList<String> > )
    {
        mVehicleServiceInterface.getVehiclesByCompany( mCurrentVehicleEnum.name, brand ).enqueue( callback )
    }
}