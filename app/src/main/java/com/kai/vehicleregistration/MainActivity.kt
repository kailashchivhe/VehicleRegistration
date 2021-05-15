package com.kai.vehicleregistration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kai.vehicleregistration.sdk.database.VehicleDatabaseSingleton

class MainActivity : AppCompatActivity()
{
    override fun onCreate( savedInstanceState: Bundle? )
    {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )
        setSupportActionBar( findViewById(R.id.toolbar) )
        VehicleDatabaseSingleton.initDatabaseInstance( applicationContext )
    }
}