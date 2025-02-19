package com.example.composecatalog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable

fun NavigationWrapper(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login){
        composable<Login> {
            LoginScreen{navController.navigate(Home)}
        }
        composable<Home>{
            HomeScreen{name -> navController.navigate(Detail(name = name))}
        }
        composable<Detail>{backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(detail.name,
                navigateToSettings = {navController.navigate(Settings(it))},
                //Usada para navegar a un punto concreto dentro de la pila de screens
                /**navigateToBack = {navController.navigate(Login){
                    popUpTo<Login>{inclusive = true}
                }*/
                navigateToBack = {navController.navigateUp()}
                )
            }
        composable<Settings>{
            SettingsScreen()
        }
        }
    }
