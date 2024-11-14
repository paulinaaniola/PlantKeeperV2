package com.paulinaaniola.plantkeeperv2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.paulinaaniola.plantkeeperv2.feature.addplant.AddNewPlantScreen
import com.paulinaaniola.plantkeeperv2.feature.myplants.MyPlantsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.MyPlants.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.MyPlants.route) {
            MyPlantsScreen(navController)
        }
        composable(NavigationItem.AddPlant.route) {
            AddNewPlantScreen(navController)
        }
    }
}