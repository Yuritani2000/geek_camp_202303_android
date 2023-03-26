package com.example.geek202303.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("trip")
    fun getTripList(): Call<TripList>;
}