package com.kai.vehicleregistration.model

enum class FuelType( val description: String )
{
    PETROL("Petrol" ),
    DIESEL( "Diesel" ),
    CNG("CNG" ),
    PETROL_CNG( "Petrol + CNG" ),
    ELECTRIC("Electric" ),
    HYBRID( "Hybrid" ),
}