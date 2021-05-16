package com.kai.vehicleregistration.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kai.vehicleregistration.model.VehicleEntity
import com.kai.vehicleregistration.sdk.database.VehicleDatabaseSingleton
import kotlinx.coroutines.*

class VehicleHomeViewModel : ViewModel()
{
    companion object
    {
        const val TAG = "VehicleHomeViewModel"
    }

    private var mVehicleList = MutableLiveData<MutableList<VehicleEntity>>()

    fun getVehicles(): MutableLiveData<MutableList<VehicleEntity>>
    {
        runBlocking {
            launch( Dispatchers.Default )
            {
                getVehicleList()
            }
        }
        return mVehicleList
    }

    suspend fun getVehicleList() = withContext( Dispatchers.Default )
    {
        mVehicleList.postValue( VehicleDatabaseSingleton.getAllVehicles() )
    }

    fun setVehicleEntity( vehicleEntity: VehicleEntity )
    {
        VehicleDatabaseSingleton.setVehicleEntity( vehicleEntity )
    }
}