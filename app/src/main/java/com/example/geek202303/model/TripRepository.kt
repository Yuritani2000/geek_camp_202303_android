package com.example.geek202303.model

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class TripRepository {
    val service: ApiInterface = create(ApiInterface::class.java)
    private lateinit var retrofit: Retrofit
    companion object{
        val executorService = Executors.newFixedThreadPool(4)
    }

    val httpBuilder: OkHttpClient.Builder get() {
        // create http client
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()

                //header
                val request = original.newBuilder()
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())
                    .build()

                return@Interceptor chain.proceed(request)
            })
            .readTimeout(30, TimeUnit.SECONDS)

        // log interceptor
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)

        return httpClient
    }

    fun <S> create(serviceClass: Class<S>): S {
        val gson = GsonBuilder().serializeNulls().create()

        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://shiroto-server.yuritani.com:30000/")
            .client(httpBuilder.build())
            .build()

        return retrofit.create(serviceClass)
    }

    public fun getTripList(): TripList {
        var result = TripList(listOf(
            Trip(
                id = -1,
                host_id = "Error",
                host_name = "Error",
                car_license = "Error",
                car_name = "Error",
                passenger_limit = -1,
                location_from = "Error",
                location_to = "Error"
            )
        ))
        try {
            val res = service.getTripList().execute()

            if(res.isSuccessful) {
                res.body()?.let {
                    result = it
                }
            }else{
                Log.d("message2", "error_code" + res.code())
            }

        } catch (e: IOException) {
            Log.i("message2", "error:" + e.message)
        }
        return result
    }
}