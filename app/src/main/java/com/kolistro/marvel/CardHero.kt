package com.kolistro.marvel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kolistro.marvel.navigation.NavRoute

/**
 * Отвечает за внешний вид карточки героя
 * @param hero параметр класса ItemHero, отвечает за данные о герое (фото, имя, цвет)
 * @param navController компонент навигации
 */
@Composable
fun CardHero(navController: NavHostController, hero: MutableState<ItemHero>) {
    Box(modifier = Modifier,
        contentAlignment = Alignment.BottomStart,
    ){/*
        Image(modifier= Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { navController.navigate(NavRoute.HeroScreen.route)},
              painter = painterResource(id = hero.value.imageId),
              contentDescription = hero.value.name
        )*/
        AsyncImage(
            modifier= Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable { navController.navigate(NavRoute.HeroScreen.route)},
            placeholder = painterResource(hero.value.imageId),
            model = "https://terrigen-cdn-dev.marvel.com/content/prod/1x/${hero.value.link}",
            contentDescription = hero.value.description,

        )
        Text(text = hero.value.name,
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(25.dp, 15.dp)
        )
    }
}