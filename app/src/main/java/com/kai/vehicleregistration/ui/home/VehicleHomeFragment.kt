package com.kai.vehicleregistration.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kai.vehicleregistration.R
import kotlinx.android.synthetic.main.fragment_vehicle_home.*

class VehicleHomeFragment : Fragment()
{
    private lateinit var mVehicleHomeViewModel: VehicleHomeViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_home, container, false)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
        add_fab.setOnClickListener {
            findNavController().navigate( R.id.action_VehicleHomeFragment_to_NewVehicleFragment )
        }
        initActionBar()
    }

    fun initActionBar()
    {
        (activity as AppCompatActivity).supportActionBar?.title = getString( R.string.vehicles )
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? )
    {
        super.onActivityCreated(savedInstanceState)
        mVehicleHomeViewModel = ViewModelProvider( this ).get( VehicleHomeViewModel::class.java )
        mVehicleHomeViewModel.getVehicles()
    }
}