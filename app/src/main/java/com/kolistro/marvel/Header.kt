package com.kolistro.marvel

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Отвечает за заголовок экрана
 */
@Composable
fun Header() {
    Text(text = "Choose your hero",
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}