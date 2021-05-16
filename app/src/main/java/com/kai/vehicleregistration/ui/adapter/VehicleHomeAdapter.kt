package com.kai.vehicleregistration.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kai.vehicleregistration.R
import com.kai.vehicleregistration.model.VehicleEntity
import kotlinx.android.synthetic.main.item_vehicle_layout.view.*

class VehicleHomeAdapter( private var mVehicleList: MutableList<VehicleEntity>, private val listener: ( VehicleEntity ) -> Unit ):
    ListAdapter< VehicleEntity, VehicleHomeAdapter.VehicleViewHolder>( VehicleEntityDiffUtil() )
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder
    {
        return VehicleViewHolder( LayoutInflater.from(parent.context).inflate( R.layout.item_vehicle_layout, parent, false ) )
    }

    override fun onBindViewHolder( holder: VehicleViewHolder, position: Int )
    {
        holder.bindTo( getItem(position), listener )
    }

    class VehicleViewHolder( itemView: View ) : RecyclerView.ViewHolder( itemView )
    {
        @SuppressLint("SetTextI18n")
        fun bindTo(vehicleEntity: VehicleEntity, listener: ( VehicleEntity ) -> Unit )
        {
            itemView.title.text = vehicleEntity.mVehicleNumber
            itemView.subtitle.text = "${vehicleEntity.mCompany}  ${vehicleEntity.mModel}"
            itemView.setOnClickListener{ listener( vehicleEntity ) }
        }
    }
}