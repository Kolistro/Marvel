package com.kolistro.marvel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolistro.marvel.overview.OverviewViewModel
import com.kolistro.marvel.screens.MainScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kolistro.marvel.screens.HeroScreen

/**
 * Навигация по страницам приложения
 */
@Composable
fun ScreenNavHost( ) {
    val viewModel = viewModel(modelClass = OverviewViewModel::class.java)
    val dataHeroes by viewModel.marvelData.observeAsState()
    val hero by viewModel.character.observeAsState()

    val navController = rememberNavController()

    NavHost(navController = navController,
            startDestination = NavRoute.MainScreen.route){
        composable(NavRoute.MainScreen.route){
            MainScreen(dataHeroes, navController = navController, viewModel)
        }
        composable(NavRoute.HeroScreen.route){
            HeroScreen(hero = hero, navController = navController)
        }
    }
}