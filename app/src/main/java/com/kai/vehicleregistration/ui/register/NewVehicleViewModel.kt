package com.kai.vehicleregistration.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kai.vehicleregistration.sdk.network.VehicleSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    fun getVehicles( companyName: String ): MutableLiveData<MutableList<String>>
    {
        VehicleSingleton.getVehiclesByCompany( companyName, object: Callback<MutableList<String>>{
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
}