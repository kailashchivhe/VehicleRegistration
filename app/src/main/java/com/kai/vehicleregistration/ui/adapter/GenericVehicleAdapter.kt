package com.kai.vehicleregistration.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kai.vehicleregistration.R
import kotlinx.android.synthetic.main.item_vehicle_layout.view.*

class GenericVehicleAdapter( private var mItemList: MutableList<String>, private val listener: (String) -> Unit ):
    ListAdapter<String, GenericVehicleAdapter.ItemViewHolder>( GenericItemDiffUtil() )
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        return ItemViewHolder( LayoutInflater.from(parent.context).inflate( R.layout.item_generic_layout, parent, false ) )
    }

    override fun onBindViewHolder( holder: ItemViewHolder, position: Int )
    {
        holder.bindTo( getItem(position), listener )
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder( itemView )
    {
        fun bindTo( item: String, listener: (String) -> Unit )
        {
            itemView.title.text = item
            itemView.setOnClickListener{ listener( item ) }
        }
    }
}