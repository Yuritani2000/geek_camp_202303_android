package com.example.geek202303.navigation

sealed class TripList(val route: String) {
    object Main : TripList(route = "main")
}