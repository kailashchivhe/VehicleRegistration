package com.kai.vehicleregistration.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kai.vehicleregistration.model.VehicleEntity


class VehicleEntityDiffUtil : DiffUtil.ItemCallback<VehicleEntity>()
{
    override fun areItemsTheSame(oldItem: VehicleEntity, newItem: VehicleEntity): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: VehicleEntity, newItem: VehicleEntity): Boolean = oldItem == newItem

}