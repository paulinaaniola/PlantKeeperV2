package com.paulinaaniola.plantkeeperv2.navigation

enum class Screen {
    MY_PLANTS,
    ADDPLANT,
}
sealed class NavigationItem(val route: String) {
    object MyPlants : NavigationItem(Screen.MY_PLANTS.name)
    object AddPlant : NavigationItem(Screen.ADDPLANT.name)
}