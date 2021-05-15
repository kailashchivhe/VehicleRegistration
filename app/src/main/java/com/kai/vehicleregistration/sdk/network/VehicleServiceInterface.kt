package com.kai.vehicleregistration.sdk.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleServiceInterface
{
    @GET("turbo/care/v1/makes")
    fun getCompaniesByType( @Query("class") type: String ): Call< MutableList<String> >

    @GET("turbo/care/v1/models")
    fun getVehiclesByCompany( @Query("class") type: String, @Query("make") company: String ): Call< MutableList<String> >
}