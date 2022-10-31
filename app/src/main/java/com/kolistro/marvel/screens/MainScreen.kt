package com.kolistro.marvel.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kolistro.marvel.CardHero
import com.kolistro.marvel.Header
import com.kolistro.marvel.ItemHero
import com.kolistro.marvel.Logo
import com.kolistro.marvel.ui.theme.Grey100

/**
 * Главный экран приложения
 * @param hero состояние отвечающее за героя, находящегося в данный момент на экране
 * @param listHero список всех героев
 * @param navController компонент навигации
 */
@Composable
fun MainScreen(
    listHero: List<ItemHero>,
    hero: MutableState<ItemHero>,
    navController: NavHostController
) {
    //состояние, отвечающее за цвет героя
    val color = remember {
        mutableStateOf(Grey100)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .background(
                   Brush.linearGradient(
                       colors = listOf(
                           Color.DarkGray,
                           Grey100,
                           Grey100,
                           color.value //цвет героя, изменяется при переключении
                       )
                   )
               )
               .fillMaxSize()
    )
    {
        Logo()
        Header()
        LazyRow(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 40.dp),
            ){
            itemsIndexed(
                listHero

            ){_, item ->
                hero.value = item
                CardHero(navController, hero)
                color.value = item.color
            }

        }
    }

}