package com.kolistro.marvel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Отвечает за внешний вид карточки героя
 * @param item параметр класса ItemHero, отвечает за данные о герое (фото, имя, цвет)
 *
 */
@Composable
fun CardHero(item: ItemHero) {
    Box(
        contentAlignment = Alignment.BottomCenter,
    ){
        Image(modifier= Modifier
            .clip(RoundedCornerShape(16.dp)),
              painter = painterResource(id = item.imageId),
              contentDescription = "image",
        )

        Text(text = item.name,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold

        )
    }

}