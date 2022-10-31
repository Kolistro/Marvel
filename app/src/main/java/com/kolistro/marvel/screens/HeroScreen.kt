package com.kolistro.marvel.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kolistro.marvel.CardHero
import com.kolistro.marvel.ItemHero
import com.kolistro.marvel.R
import com.kolistro.marvel.navigation.NavRoute
import com.kolistro.marvel.ui.theme.Grey100

/**
 * Экран с информацией о главном герое
 * @param hero состояние отвечающее за героя, находящегося в данный момент на экране
 * @param navController компонент навигации
 */
@Composable
fun HeroScreen(hero: MutableState<ItemHero>, navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Grey100),
        contentAlignment = Alignment.TopStart
    ) {

        Column {
            CardHero(navController = navController, hero = hero)
            Text(text = hero.value.description,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(25.dp, 15.dp)
            )
        }
        //почему меняется цвет фона, а не самой картинки
        IconButton(onClick = { navController.navigate(NavRoute.MainScreen.route) }) {
            Icon(imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "arrow_back",
                modifier = Modifier
                    .background(Color.White)
                    .size(50.dp)
                    .padding(80.dp),
                tint = Color.Blue
            )
        }
    }
}

@Preview
@Composable
fun PreviewHeroScreen(){
     HeroScreen(hero = remember {
         mutableStateOf(ItemHero("026ddm_ons_crd_02_1.jpg",R.drawable.daredevil, "Hero", Grey100, "I'm Groot"))
     },
         navController = rememberNavController()
     )
}