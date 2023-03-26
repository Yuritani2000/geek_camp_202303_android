package com.example.geek202303.viewmodel

data class TripState(
    val id: Int,
    val hostId: String,
    val hostName: String,
    val carLicense: String,
    val carName: String,
    val passengerLimit: Int,
    val locationFrom: String,
    val locationTo: String
){
    companion object {
        val initialState = TripState(
            id = 0,
            hostId = "",
            hostName = "",
            carLicense = "",
            carName = "",
            passengerLimit = 0,
            locationFrom = "",
            locationTo = ""
        )
    }
}
