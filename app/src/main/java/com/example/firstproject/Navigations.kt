package com.example.firstproject

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType

import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation () {
    val navController = rememberNavController()
    Surface (modifier = Modifier.fillMaxWidth()) {
        NavHost(navController =navController
            , startDestination = "home"
             ){
            composable("home"){
                MainContent(navController)

            }
            composable("details?user={user}",
                arguments = listOf(
                    navArgument("user"){
                        type= NavType.StringType
                        defaultValue = "No Data found"

                    }
                )
            ){
                val user = it.arguments?.getString("user")
              Details(navController,user)

            }
        }
    }

}