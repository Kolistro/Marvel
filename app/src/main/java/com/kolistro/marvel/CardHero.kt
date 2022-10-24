package com.kolistro.marvel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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