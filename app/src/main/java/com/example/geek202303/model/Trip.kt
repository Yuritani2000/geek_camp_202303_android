package com.example.geek202303.model

data class Trip(
    var id: Int,
    var host_id: String,
    var host_name: String,
    var car_license: String,
    var car_name: String,
    var passenger_limit: Int,
    var location_from: String,
    var location_to: String
)