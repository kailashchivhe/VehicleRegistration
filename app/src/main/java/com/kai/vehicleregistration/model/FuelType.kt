package com.kai.vehicleregistration.model

enum class FuelType( val description: String )
{
    PETROL("Petrol" ),
    DIESEL( "Diesel" ),
    CNG("CNG" ),
    PETROL_CNG( "Petrol + CNG" ),
    ELECTRIC("Electric" ),
    HYBRID( "Hybrid" );

    companion object
    {
        fun getFuelTypeFromDescription( fuelTypeDescription: String ): FuelType
        {
            var result = FuelType.PETROL
            for( fuelType in FuelType.values() )
            {
                if( fuelType.description == fuelTypeDescription )
                {
                    result = fuelType
                }
            }
            return result
        }
    }
}