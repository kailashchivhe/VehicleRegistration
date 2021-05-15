package com.kai.vehicleregistration.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.vehicleregistration.R


class NewVehicleFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_vehicle, container, false)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? )
    {
        super.onViewCreated(view, savedInstanceState)
    }
}