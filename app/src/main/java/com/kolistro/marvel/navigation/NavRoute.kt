package com.kolistro.marvel.navigation

sealed class NavRoute(val route: String){
    object MainScreen: NavRoute("main_screen")
    object HeroScreen: NavRoute("hero_screen")
}