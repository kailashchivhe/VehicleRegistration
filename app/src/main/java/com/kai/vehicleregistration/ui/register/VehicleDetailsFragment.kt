package com.kai.vehicleregistration.ui.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kai.vehicleregistration.R
import kotlinx.android.synthetic.main.fragment_vehicle_details.*
import java.util.*

class VehicleDetailsFragment : Fragment()
{
    private lateinit var mVehicleRegisterViewModel: VehicleRegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_vehicle_details, container, false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
        mVehicleRegisterViewModel = ViewModelProvider(this).get( VehicleRegisterViewModel::class.java )
        initActionBar()
        setHasOptionsMenu( true )
        loadData()
    }

    @SuppressLint("SetTextI18n")
    private fun loadData()
    {
        val vehicleEntity = mVehicleRegisterViewModel.getVehicleDetails()
        title.text = "${vehicleEntity.mModel.toUpperCase(Locale.ROOT)} ${vehicleEntity.mFuelType}"
        subTitle.text = vehicleEntity.mVehicleNumber.toUpperCase(Locale.ROOT)
        makeSubTitle.text = vehicleEntity.mCompany.toUpperCase(Locale.ROOT)
        modelSubTitle.text = vehicleEntity.mModel.toUpperCase(Locale.ROOT)
        fuelSubTitle.text = vehicleEntity.mFuelType.description.toUpperCase(Locale.ROOT)
        transmissionSubTitle.text = vehicleEntity.mTransmission.description.toUpperCase(Locale.ROOT)
    }

    override fun onOptionsItemSelected( item: MenuItem): Boolean
    {
        when ( item.itemId )
        {
            android.R.id.home->
            {
                findNavController().navigate( R.id.action_VehicleDetailsFragment_to_VehicleHomeFragment )
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun initActionBar()
    {
        (activity as AppCompatActivity).supportActionBar?.title = ""
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}