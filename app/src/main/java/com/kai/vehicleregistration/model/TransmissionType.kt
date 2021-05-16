package com.kai.vehicleregistration.model

enum class TransmissionType ( val description: String )
{
    MANUAL("Manual" ),
    AUTOMATIC( "Automatic" );

    companion object
    {
        fun getTransmissionTypeFromDescription(transmissionTypeDescription: String ): TransmissionType
        {
            var result = TransmissionType.AUTOMATIC
            for( transmissionType in TransmissionType.values() )
            {
                if( transmissionType.description == transmissionTypeDescription )
                {
                    result = transmissionType
                }
            }
            return result
        }
    }
}