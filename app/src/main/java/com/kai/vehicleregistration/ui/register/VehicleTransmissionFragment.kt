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
import com.kai.vehicleregistration.model.TransmissionType
import com.kai.vehicleregistration.ui.adapter.GenericVehicleAdapter
import kotlinx.android.synthetic.main.fragment_generic_list.*

class VehicleTransmissionFragment: Fragment()
{
    private lateinit var mNewVehicleViewModel: NewVehicleViewModel

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mAdapter: GenericVehicleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_generic_list, container, false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
        mNewVehicleViewModel = ViewModelProvider(this).get( NewVehicleViewModel::class.java )
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
        mAdapter.submitList( mNewVehicleViewModel.getTransmissionList() )
    }

    private fun onItemClicked( transmissionType: String )
    {
        mNewVehicleViewModel.setVehicleTransmission( TransmissionType.getTransmissionTypeFromDescription( transmissionType ) )
//        findNavController().navigate( R.id.action_NewVehicleFragment_to_VehicleCompanyFragment )
    }

    fun initActionBar()
    {
        (activity as AppCompatActivity).supportActionBar?.title = getString( R.string.select_transmission )
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}