package com.kolistro.marvel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.kolistro.marvel.navigation.NavRoute
import com.kolistro.marvel.network.characters.Result

/**
 * Отвечает за внешний вид карточки героя
 * @param hero параметр класса ItemHero, отвечает за данные о герое (фото, имя, цвет)
 * @param navController компонент навигации
 */
@Composable
fun CardHero(navController: NavHostController, hero: Result?) {
    Box(modifier = Modifier.size(width = 380.dp, height = 480.dp),
        contentAlignment = Alignment.BottomStart,
    ){
        if (hero != null) {
            AsyncImage(
                modifier= Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(25.dp))
                    .clickable { navController.navigate(NavRoute.HeroScreen.route)},
                model = hero.thumbnail.path + ".jpg",
                contentDescription = hero.name,
            )
        }
        if (hero != null) {
            Text(text = hero.name,
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(25.dp, 15.dp)
            )
        }
    }

}