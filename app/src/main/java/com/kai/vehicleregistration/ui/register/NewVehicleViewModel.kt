package com.kai.vehicleregistration.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kai.vehicleregistration.model.FuelType
import com.kai.vehicleregistration.model.TransmissionType
import com.kai.vehicleregistration.sdk.database.VehicleDatabaseSingleton
import com.kai.vehicleregistration.sdk.network.VehicleSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NewVehicleViewModel: ViewModel()
{
    companion object
    {
        const val TAG = "NewVehicleViewModel"
    }

    private var mCompanyList = MutableLiveData<MutableList<String>>()
    private var mVehicleList = MutableLiveData<MutableList<String>>()

    fun getCompanies(): MutableLiveData<MutableList<String>>
    {
        VehicleSingleton.getCompaniesByType( object: Callback<MutableList<String>>{
            override fun onResponse( call: Call<MutableList<String>>, response: Response<MutableList<String>> )
            {
                mCompanyList.postValue( response.body() )
            }

            override fun onFailure( call: Call<MutableList<String>>, t: Throwable )
            {
                mCompanyList.postValue( mutableListOf() )
            }
        })
        return mCompanyList
    }

    fun getVehicles(): MutableLiveData<MutableList<String>>
    {
        VehicleSingleton.getVehiclesByCompany( VehicleDatabaseSingleton.getVehicleEntity().mCompany.toLowerCase(
            Locale.ROOT ), object: Callback<MutableList<String>>{
            override fun onResponse( call: Call<MutableList<String>>, response: Response<MutableList<String>> )
            {
                mVehicleList.postValue( response.body() )
            }

            override fun onFailure( call: Call<MutableList<String>>, t: Throwable )
            {
                mVehicleList.postValue( mutableListOf() )
            }
        })
        return mVehicleList
    }

    fun getFuelList(): MutableList<String>
    {
        val fuelTypeList = mutableListOf<String>()
        fuelTypeList.add( FuelType.PETROL.description )
        fuelTypeList.add( FuelType.DIESEL.description )
        fuelTypeList.add( FuelType.CNG.description )
        fuelTypeList.add( FuelType.PETROL_CNG.description )
        fuelTypeList.add( FuelType.ELECTRIC.description )
        fuelTypeList.add( FuelType.HYBRID.description )
        return fuelTypeList
    }

    fun getTransmissionList(): MutableList<String>
    {
        val transmissionTypeList = mutableListOf<String>()
        transmissionTypeList.add( TransmissionType.AUTOMATIC.description )
        transmissionTypeList.add( TransmissionType.MANUAL.description  )
        return transmissionTypeList
    }

    fun setVehicleNumber( vehicleNumber: String )
    {
        VehicleDatabaseSingleton.setVehicleNumber( vehicleNumber )
    }

    fun setVehicleCompany( companyName: String )
    {
        VehicleDatabaseSingleton.setVehicleCompany( companyName )
    }

    fun setVehicleModel( vehicleModel : String )
    {
        VehicleDatabaseSingleton.setVehicleModel( vehicleModel )
    }

    fun setVehicleFuelType( fuelType: FuelType )
    {
        VehicleDatabaseSingleton.setVehicleFuelType( fuelType )
    }

    fun setVehicleTransmission( transmissionType: TransmissionType )
    {
        VehicleDatabaseSingleton.setVehicleTransmission( transmissionType )
    }
}