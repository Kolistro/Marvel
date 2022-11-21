package com.kolistro.marvel.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.kolistro.marvel.navigation.NavRoute
import com.kolistro.marvel.network.characters.Result
import com.kolistro.marvel.ui.theme.Grey100

/**
 * Экран с информацией о главном герое
 * @param hero состояние отвечающее за героя, находящегося в данный момент на экране
 * @param navController компонент навигации
 */
@Composable
fun HeroScreen(hero: Result?, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey100),
        contentAlignment = Alignment.TopStart
    ) {
        Box(contentAlignment = Alignment.BottomStart) {
            if (hero != null) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25.dp)),
                    model = hero.thumbnail.path + "." + hero.thumbnail.extension,
                    contentDescription = hero.name,
                )
            }
            Column {
                if (hero != null) {
                    Text(
                        text = hero.name,
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(25.dp, 5.dp)
                    )
                    Text(
                        text = hero.description,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(25.dp, 5.dp)
                    )
                }
            }
        }

        //почему меняется цвет фона, а не самой картинки
        IconButton(onClick = { navController.navigate(NavRoute.MainScreen.route) }) {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "arrow_back",
                modifier = Modifier
                    // .background(Color.White)
                    .size(70.dp)
                    .padding(80.dp),
                tint = Color.Black
            )
        }
    }
}

