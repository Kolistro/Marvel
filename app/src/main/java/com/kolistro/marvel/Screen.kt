package com.kolistro.marvel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.kolistro.marvel.ui.theme.Grey100

/**
 * Отвечает за вывод на экран всех функций в нужном формате
 */
@Composable
fun Screen(){
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
        ListHero(color)
    }

}