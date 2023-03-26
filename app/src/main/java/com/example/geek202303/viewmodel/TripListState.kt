package com.example.geek202303.viewmodel

data class TripListState(
    val tripList: List<TripState>
){
    companion object {
        val initialState = TripListState(emptyList<TripState>())
    }
}
