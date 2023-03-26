package com.example.geek202303.view

sealed class TripListEvent
object OnClickTripEvent : TripListEvent()
object UpdateListEvent : TripListEvent()