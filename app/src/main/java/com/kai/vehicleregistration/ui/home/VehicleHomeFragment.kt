package com.kai.vehicleregistration.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kai.vehicleregistration.R

class VehicleHomeFragment : Fragment()
{
    private lateinit var mVehicleHomeViewModel: VehicleHomeViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_home, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? )
    {
        super.onActivityCreated(savedInstanceState)
        mVehicleHomeViewModel = ViewModelProvider( this ).get( VehicleHomeViewModel::class.java )
        mVehicleHomeViewModel.getVehicles()
    }
}