package com.example.geek202303.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.geek202303.view.TripList

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = TripList.Main.route,
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = TripList.Main.route) {
            TripList()
        }
    }
}