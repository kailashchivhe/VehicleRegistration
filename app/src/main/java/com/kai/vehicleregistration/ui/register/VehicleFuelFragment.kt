package com.kai.vehicleregistration.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kai.vehicleregistration.R
import com.kai.vehicleregistration.model.FuelType
import com.kai.vehicleregistration.ui.adapter.GenericVehicleAdapter
import kotlinx.android.synthetic.main.fragment_vehicle_generic_list.*

class VehicleFuelFragment : Fragment()
{
    private lateinit var mVehicleRegisterViewModel: VehicleRegisterViewModel

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mAdapter: GenericVehicleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_vehicle_generic_list, container, false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
        mVehicleRegisterViewModel = ViewModelProvider(this).get( VehicleRegisterViewModel::class.java )
        initActionBar()
        setHasOptionsMenu( true )
        initRecyclerView()
    }

    override fun onOptionsItemSelected( item: MenuItem): Boolean
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

    private fun initRecyclerView()
    {
        mRecyclerView = recycler_view
        mRecyclerView.layoutManager = LinearLayoutManager( activity )
        mAdapter = GenericVehicleAdapter( mutableListOf()) {
            onItemClicked(it)
        }
        mRecyclerView.adapter = mAdapter
        progressBar.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
        mAdapter.submitList( mVehicleRegisterViewModel.getFuelList() )
    }

    private fun onItemClicked( fuelType: String )
    {
        mVehicleRegisterViewModel.setVehicleFuelType( FuelType.getFuelTypeFromDescription( fuelType ) )
        findNavController().navigate( R.id.action_VehicleFuelFragment_to_VehicleTransmissionFragment )
    }

    fun initActionBar()
    {
        (activity as AppCompatActivity).supportActionBar?.title = getString( R.string.select_fuel )
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}