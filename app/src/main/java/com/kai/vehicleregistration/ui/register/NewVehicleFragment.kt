package com.kai.vehicleregistration.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kai.vehicleregistration.R
import com.kai.vehicleregistration.model.VehicleType
import com.kai.vehicleregistration.sdk.network.VehicleSingleton
import kotlinx.android.synthetic.main.fragment_new_vehicle.*


class NewVehicleFragment : Fragment()
{
    private lateinit var mNewVehicleViewModel: NewVehicleViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_vehicle, container, false)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
        mNewVehicleViewModel = ViewModelProvider(this).get( NewVehicleViewModel::class.java )
        initActionBar()
        setHasOptionsMenu( true )
        initRadioButton()
        onNextClick()
    }

    override fun onOptionsItemSelected( item: MenuItem ): Boolean
    {
        when ( item.itemId )
        {
            android.R.id.home->
            {
                findNavController().navigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initActionBar()
    {
        (activity as AppCompatActivity).supportActionBar?.title = getString( R.string.create_new_profile )
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun onNextClick()
    {
        next_fab.setOnClickListener {
            mNewVehicleViewModel.setVehicleNumber( vehicle_no_edit_text.text.toString() )
            findNavController().navigate( R.id.action_NewVehicleFragment_to_VehicleCompanyFragment )
        }
    }

    private fun initRadioButton()
    {
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when( checkedId )
            {
                R.id.twoWheeler ->{
                    VehicleSingleton.mCurrentVehicleEnum = VehicleType.TWO_WHEELER
                }
                R.id.fourWheeler->{
                    VehicleSingleton.mCurrentVehicleEnum = VehicleType.FOUR_WHEELER
                }
            }
        }
    }
}