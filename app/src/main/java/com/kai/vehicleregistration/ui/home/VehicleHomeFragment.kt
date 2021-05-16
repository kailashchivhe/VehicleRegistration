package com.kai.vehicleregistration.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kai.vehicleregistration.R
import com.kai.vehicleregistration.model.VehicleEntity
import com.kai.vehicleregistration.ui.adapter.VehicleHomeAdapter
import kotlinx.android.synthetic.main.fragment_vehicle_home.*

class VehicleHomeFragment : Fragment()
{
    private lateinit var mVehicleHomeViewModel: VehicleHomeViewModel

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mAdapter: VehicleHomeAdapter

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_home, container, false)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
        mVehicleHomeViewModel = ViewModelProvider( this ).get( VehicleHomeViewModel::class.java )
        add_fab.setOnClickListener {
            findNavController().navigate( R.id.action_VehicleHomeFragment_to_VehicleRegisterFragment )
        }
        initActionBar()
        initRecyclerView()
        loadData()
    }

    private fun loadData()
    {
        activity?.let { fragmentActivity ->
            mVehicleHomeViewModel.getVehicles().observe(fragmentActivity, {
                if( it.size > 0 )
                {
                    progressBar.visibility = View.GONE
                    recycler_view.visibility = View.VISIBLE
                    mAdapter.submitList(it)
                }
                else
                {
                    progressBar.visibility = View.GONE
                    status_text_view.visibility = View.VISIBLE
                }
            })
        }
    }

    private fun initRecyclerView()
    {
        mRecyclerView = recycler_view
        mRecyclerView.layoutManager = LinearLayoutManager( activity )
        mAdapter = VehicleHomeAdapter( mutableListOf()){
            onItemClicked( it )
        }
        mRecyclerView.adapter = mAdapter
    }

    private fun onItemClicked( it: VehicleEntity )
    {
        mVehicleHomeViewModel.setVehicleEntity( it )
        findNavController().navigate( R.id.action_VehicleHomeFragment_to_VehicleDetailsFragment )
    }

    fun initActionBar()
    {
        (activity as AppCompatActivity).supportActionBar?.title = getString( R.string.vehicles )
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }
}