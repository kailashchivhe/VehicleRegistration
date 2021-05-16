package com.kai.vehicleregistration.ui.adapter

import androidx.recyclerview.widget.DiffUtil

class GenericItemDiffUtil : DiffUtil.ItemCallback<String>()
{
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

}