package com.kai.vehicleregistration.sdk.network

import com.kai.vehicleregistration.model.Company
import com.kai.vehicleregistration.model.Vehicle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleServiceInterface
{
    @GET("makes")
    fun getCompaniesByType( @Query("class") type: String ): Call<Company>

    @GET("models")
    fun getVehiclesByCompany( @Query("class") type: String, @Query("make") company: String ): Call<Vehicle>
}