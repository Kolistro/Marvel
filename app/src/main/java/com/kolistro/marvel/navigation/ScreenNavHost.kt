package com.kolistro.marvel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolistro.marvel.ItemHero
import com.kolistro.marvel.screens.HeroScreen
import com.kolistro.marvel.screens.MainScreen


/**
 * Навигация по страницам приложения
 * @param hero состояние отвечающее за героя, находящегося в данный момент на экране
 * @param listHero список всех героев
 */
@Composable
fun ScreenNavHost(listHero: List<ItemHero>, hero: MutableState<ItemHero>) {
    val navController = rememberNavController()
    
    NavHost(navController = navController,
            startDestination = NavRoute.MainScreen.route){
        composable(NavRoute.MainScreen.route){
            MainScreen(listHero, hero, navController = navController)
        }
        composable(NavRoute.HeroScreen.route){
            HeroScreen(hero= hero,navController = navController)
        }
    }
}